package year1.month1.week1.day7;

import java.util.*;

public class Bellman_Ford_Queue_Improved_SPFA_C {
    //K*N 复杂度, 取决于图的稠密度, 最稠密时达到E*N(甚至更甚, 因为有队列操作)
    //动态规划
    //只对上一次松弛的节点连接的边进行松弛(最坏情况每个节点都跟彼此相连, 最坏情况每个节点都要加进队列n-1次)
    //用队列记录上一次松弛的节点
    //用visited记录已经在队列的点(防止重复放进队列, 弹出后要设置回false)

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

        int[] res = new int[n+1];
        while (!queue.isEmpty()){
            int s=queue.poll();
            visited[s]=false; //去除标记, 可能需要多次遍历节点

            for (int[] edge : edges.get(s)){
                int t=edge[0];
                int val=edge[1];

                if (minList[s]+val<minList[t]){
                    minList[t]=minList[s]+val;

                    if (!visited[t]){
                        queue.add(t);
                        visited[t]=true; //标记为已添加进队列

                        res[t]=s; //s与t位置得互换, 这行没用, 是打印的
                    }
                }
            }
        }

        if (minList[n]!=Integer.MAX_VALUE){
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
