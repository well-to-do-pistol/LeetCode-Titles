package year1.month1.week1.day7;

import java.util.*;

//记录了原版和队列优化(SPFA)版(其中一版被注释了)

public class Bellman_Ford_Limited_k_C {
    //K*H(H<=E)时间复杂度
    //SPFA版
    //适用preMinList数组循环K+1次, 每次计算每层队列长度, 限制每次只遍历该层节点
    //原因和原版一样, 防止负权回路和超界路径(因为一次松弛可能导致下层的松弛, 必须控制)
    //为什么要用领接表:因为是SPFA, 将点加进路径, 是优化版, 只关注与节点相连的边
    //queue别重复添加了(重复添加会产生多余操作)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            graph.get(s).add(new Edge(t,val));
        }

        int src = scanner.nextInt();
        int dst = scanner.nextInt();
        int k = scanner.nextInt();

        int[] minList=new int[n+1];
        Arrays.fill(minList,Integer.MAX_VALUE);
        int[] preMinList=new int[n+1];

        minList[src]=0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        k++; //将k变成k+1

        boolean[] visited=new boolean[n+1];
        visited[src]=true;

        while (k-->0 && !queue.isEmpty()){ //k+1次
            System.arraycopy(minList,0,preMinList,0,n+1); //复制, 用先前minList更新minList
            int queueSize = queue.size(); //计算每层的节点数

            while (queueSize-->0){
                int s=queue.poll();
                visited[s]=false;
                for (Edge edge:graph.get(s)){
                    int t=edge.to;
                    int val=edge.val;

                    if (preMinList[s]!=Integer.MAX_VALUE && preMinList[s]+val<minList[t]){ //最大值不能相加否则会超界
                        minList[t]=preMinList[s]+val;

                        if (!visited[t]){
                            queue.add(t);
                            visited[t]=true;
                        }
                    }
                }
            }
        }

        if (minList[dst]!=Integer.MAX_VALUE){
            System.out.println(minList[dst]);
        }else {
            System.out.println("unreachable");
        }
        scanner.close();
    }
}






//public class Bellman_Ford_Limited_k_C {
//    //K*E时间复杂度
//    //m+n空间复杂度
//    //   - 5 - 6 -7 -8 -
//    // 1   -  2  -  3  -  4    //k=2
//    //为了规避上面的情况以及负权回路有可能得到k+1条边的路径的情况
//    //必须采用基于上一次minList来松弛, 因为在一次所有边的松弛中可能会基于上一条边产生更多松弛(1-2-3,3本来要等到第二次才能松弛,却第一次就已松弛了)
//    //基于上一次minList, 经过k+1次松弛保证能求得s最多通过k+1条边到达某一点t的最短路径(k为最多可经过的城市)
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n=scanner.nextInt();
//        int m=scanner.nextInt();
//        List<int[]> edges = new ArrayList<>();
//        for (int i=0; i<m; i++){
//            int s=scanner.nextInt();
//            int t=scanner.nextInt();
//            int val=scanner.nextInt();
//            edges.add(new int[]{s,t,val});
//        }
//
//        int src = scanner.nextInt();
//        int dst = scanner.nextInt();
//        int k = scanner.nextInt();
//
//        int[] minList=new int[n+1];
//        Arrays.fill(minList,Integer.MAX_VALUE);
//        int[] preMinList=new int[n+1];
//
//        minList[src]=0;
//
//        for (int i=0; i<k+1; i++){ //k+1次
//            System.arraycopy(minList,0,preMinList,0,n+1); //复制, 用先前minList更新minList
//
//            for (int[] edge:edges){ //直接松弛所有边
//                int s=edge[0];
//                int t=edge[1];
//                int val=edge[2];
//
//                if (preMinList[s]!=Integer.MAX_VALUE && preMinList[s]+val<minList[t]){ //最大值不能相加否则会超界
//                    minList[t]=preMinList[s]+val;
//                }
//            }
//
//        }
//
//        if (minList[dst]!=Integer.MAX_VALUE){
//            System.out.println(minList[dst]);
//        }else {
//            System.out.println("unreachable");
//        }
//        scanner.close();
//    }
//}
