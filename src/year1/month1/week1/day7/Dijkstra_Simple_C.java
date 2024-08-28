package year1.month1.week1.day7;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra_Simple_C {
    //有重大瑕疵: 图必须完全连通(必须有从起点到终点的n-1条路径, 没有就报错)
    //minList表示距离源点的最短距离
    //和Prim差不多
    //但是Prim是无向图, 这里Dijkstra是有向图, 只能定义单方向的权值

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] grid = new int[n+1][n+1];
        for (int[] g:grid){  //先初始化,防止影响计算(因为要找最短边)
            Arrays.fill(g,Integer.MAX_VALUE);
        }
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            grid[s][t]=val;
        }

        boolean[] visited = new boolean[n+1];
        int[] minList= new int[n+1];
        Arrays.fill(minList, Integer.MAX_VALUE);

        //初始化
        minList[1]=0;

        int[] edges = new int[n+1];
        for (int i=1; i<=n; i++){ //确保遍历了每个节点
            int minVal=Integer.MAX_VALUE;
            int cur=-1;
            //1.找到最近节点
            for (int v=1; v<=n; v++){
                if (!visited[v] && minList[v]<minVal){
                    minVal=minList[v];
                    cur=v;
                }
            }

            //标记节点
            visited[cur]=true;

            //3.更新未遍历节点到源点距离
            for (int v=1; v<=n; v++){
                if (!visited[v] && grid[cur][v]!=Integer.MAX_VALUE && grid[cur][v]+minList[cur] < minList[v]){ //中间的条件是如果没有边就跳过
                    minList[v]=grid[cur][v]+minList[cur];

                    edges[v]=cur; //这行不重要, 只是用来记录边
                }
            }
        }

        if (minList[n]!=Integer.MAX_VALUE){
            System.out.println(minList[n]);
        }else {
            System.out.println(-1);
        }

        for (int i=1; i<=n; i++){
            System.out.println(edges[i]+"->"+i); //打印要倒过来打印, 因为头是藏在后面的(防止被覆盖)
        }
        scanner.close();
    }

}
