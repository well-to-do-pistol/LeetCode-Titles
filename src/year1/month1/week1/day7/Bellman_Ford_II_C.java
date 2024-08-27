package year1.month1.week1.day7;

import java.util.*;

//记录了原版和队列优化(SPFA)版(其中一版被注释了)

public class Bellman_Ford_II_C {
    //最坏情况每个节点需要被添加n-1次, 因为队列优化只是优化边少的情况, 边多优化不了
    //所以节点被添加第n次判断minList是否变化, 变化则有负权回路, 因为被添加n-1次肯定得到最优了
    //判断第n次加入节点时minList是否变化来找出负权回路
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<List<int[]>> edges = new ArrayList<>();
        for (int i=0; i<=n; i++){
            edges.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            edges.get(s).add(new int[]{t,val});
        }

        boolean[] visited = new boolean[n+1];
        int[] minList = new int[n+1];
        Arrays.fill(minList, Integer.MAX_VALUE);
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        minList[1]=0;
        visited[1]=true;

        int[] count=new int[n+1]; //记录节点被添加次数
        count[1]++;
        boolean flag=false;

        int[] res = new int[n+1]; //用来打印的
        while (!queue.isEmpty()){
            int s=queue.poll();
            visited[s]=false; //去除标记, 可能需要多次遍历节点

            for (int[] edge : edges.get(s)){
                int t=edge[0];
                int val=edge[1];

                if (minList[s]+val<minList[t]){
                    minList[t]=minList[s]+val;

                    if (!visited[t]){
                        if (count[t]==n){
                            flag=true;
                            queue.clear(); //改变while条件以退出while循环
                            break;
                        }//极端情况, 所有节点互相连接, 节点最多最多被加进队列n-1次, 肯定得到最优了
                        count[t]++;

                        queue.add(t);
                        visited[t]=true; //标记为已添加进队列

                        res[t]=s; //s与t位置得互换, 这行没用, 是打印的
                    }
                }
            }
        }

        if (flag){
            System.out.println("circle");
        }else if (minList[n]!=Integer.MAX_VALUE){
            System.out.println(minList[n]);
        }else {
            System.out.println(-1);
        }

        for (int i=1; i<=n; i++){
            System.out.println(res[i]+"->"+i); //颠倒打印, s是值
        }
        scanner.close();
    }
}







//public class Bellman_Ford_II_C {
//    //动态规划
//    //对所有边进行n次松弛
//    //第n次判断minList是否变化
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
//        int[] minList = new int[n+1];
//        Arrays.fill(minList, Integer.MAX_VALUE);
//        minList[1]=0; //初始化
//
//        boolean flag=false;
//        for (int i=0; i<n; i++){
//            for (int[] edge:edges){
//                int s=edge[0];
//                int t=edge[1];
//                int val=edge[2];
//
//                if (i==n-1 && minList[s]!=Integer.MAX_VALUE && minList[s]+val<minList[t])flag=true;//第n次松弛所有边, 只要有一条边有变化, 就有负权回路
//                if (minList[s]!=Integer.MAX_VALUE && minList[s]+val<minList[t]){ //起源不能等于最大值, 等于最大值证明它还没和源点连起来
//                    minList[t]=minList[s]+val;
//                }
//            }
//        }
//
//        if (flag){
//            System.out.println("circle");
//        }else if (minList[n]!=Integer.MAX_VALUE){
//            System.out.println(minList[n]);
//        }else {
//            System.out.println(-1);
//        }
//        scanner.close();
//    }
//}
