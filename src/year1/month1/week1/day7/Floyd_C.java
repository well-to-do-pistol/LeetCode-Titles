package year1.month1.week1.day7;

import java.util.*;

//这里写了Floyd(适用于(稠密图)全源点查找路径)和自己用Dijkstra实现(大图, 稀疏图)的两种方法
//V三次方和(O((V+E) \log V)\)复杂度


public class Floyd_C {
    //二维数组(滚动数组优化, 只能优化空间)
    //二维数组的思维其实更简单, 但是遍历顺序讲不清楚
    //既然如果dp[i][j][k-1]比dp[i][j][k]小,那自然就更新了, 如果大,也不会更新, 所以去掉k, 直接又上一次状态得到当前状态, 变为二维数组
    //dp[i][j] = dp[i][k] + dp[k][j]

    //Floyd算法, 动态规划
    //dp[i][j][k]表示从i到j经过1..k节点集合的最短距离 (用k表示经过的节点集合范围来算最短路径)
    //1.经过节点k dp[i][k][k-1]+dp[k][j][k-1] 最重要的公式, 将dp分解得到
    //2.不经过节点k dp[i][j][k-1]

    //遍历顺序
    // 1 -(10)- 2           //for(i=1)            //dp[1][2][4]最短路径需要dp[1][3][3]来算, 但遍历到前者的时候后者还没遍历到
    // |        |           //   for(j=1)
    //(1)       (1)         //     for(k=1)
    // |        |
    // 3 -(1)-  4

    // 1 -(1)-  2 -(10)- 3   //for(i=1)           //dp[1][3][2]最短路径需要dp[1][2][1]和dp[2][3][1]来算, 但遍历到前者的时候后者还没遍历到
    //                       //  for(k=1)
    //                       //    for(j=1)

    //dp[k]是依赖于dp[k-1]的, 所以必须从小到大, 而且以i,j为平面, k为垂直线一直向上延伸得到结果, 所有k层放在最外面

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int m= scanner.nextInt();
        int[][] dp = new int[n+1][n+1];
        for (int[] p:dp)Arrays.fill(p,10005); //不能用最大值, 因为要相加, 而边小于等于10的4次方
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            dp[s][t]=val;
            dp[t][s]=val;
        }

        for (int k=1; k<=n; k++){
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    dp[i][j] = Math.min( dp[i][j] , dp[i][k]+dp[k][j] );
                }
            }
        }

        int Q=scanner.nextInt();
        while (Q-->0){
            int start=scanner.nextInt();
            int end=scanner.nextInt();

            if (dp[start][end]==10005){
                System.out.print(-1);
            }else {
                System.out.print(dp[start][end]);
            }
            if (Q>0) System.out.print(" ");
        }
        scanner.close();
    }
}









//public class Floyd_C {
//    //三维数组
//    //Floyd算法, 动态规划
//    //dp[i][j][k]表示从i到j经过1..k节点集合的最短距离 (用k表示经过的节点集合范围来算最短路径)
//    //1.经过节点k dp[i][k][k-1]+dp[k][j][k-1] 最重要的公式, 将dp分解得到
//    //2.不经过节点k dp[i][j][k-1]
//
//    //遍历顺序
//    // 1 -(10)- 2           //for(i=1)            //dp[1][2][4]最短路径需要dp[1][3][3]来算, 但遍历到前者的时候后者还没遍历到
//    // |        |           //   for(j=1)
//    //(1)       (1)         //     for(k=1)
//    // |        |
//    // 3 -(1)-  4
//
//    // 1 -(1)-  2 -(10)- 3   //for(i=1)           //dp[1][3][2]最短路径需要dp[1][2][1]和dp[2][3][1]来算, 但遍历到前者的时候后者还没遍历到
//    //                       //  for(k=1)
//    //                       //    for(j=1)
//
//    //dp[k]是依赖于dp[k-1]的, 所以必须从小到大, 而且以i,j为平面, k为垂直线一直向上延伸得到结果, 所有k层放在最外面
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n= scanner.nextInt();
//        int m= scanner.nextInt();
//        int[][][] dp = new int[n+1][n+1][n+1];
//        for (int[][] d:dp){
//            for (int[] p:d)Arrays.fill(p,10005); //不能用最大值, 因为要相加, 而边小于等于10的4次方
//        }
//        for (int i=0; i<m; i++){
//            int s=scanner.nextInt();
//            int t=scanner.nextInt();
//            int val=scanner.nextInt();
//            dp[s][t][0]=val;
//            dp[t][s][0]=val;
//        }
//
//        for (int k=1; k<=n; k++){
//            for (int i=1; i<=n; i++) {
//                for (int j=1; j<=n; j++) {
//                    dp[i][j][k] = Math.min( dp[i][j][k-1] , dp[i][k][k-1]+dp[k][j][k-1] );
//                }
//            }
//        }
//
//        int Q=scanner.nextInt();
//        while (Q-->0){
//            int start=scanner.nextInt();
//            int end=scanner.nextInt();
//
//            if (dp[start][end][n]==10005){
//                System.out.print(-1);
//            }else {
//                System.out.print(dp[start][end][n]);
//            }
//            if (Q>0) System.out.print(" ");
//        }
//        scanner.close();
//    }
//}









//public class Floyd_C {
//    //双向
//    //Dijkstra(朴素不行用优先队列优化)
//    //minList距离源点距离
//    //1.找出最近节点
//    //2.标记节点
//    //3.更新minList
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n=scanner.nextInt();
//        int m=scanner.nextInt();
//        List<List<Edge>> graph = new ArrayList<>();
//        for (int i=0; i<=n; i++){
//            graph.add(new ArrayList<>());
//        }
//        for (int i=0; i<m; i++){
//            int s=scanner.nextInt();
//            int t=scanner.nextInt();
//            int val=scanner.nextInt();
//            graph.get(s).add(new Edge(t,val));
//        }
//        int Q=scanner.nextInt(); //观景计划数量
//        int[] res = new int[Q];
//
//        for (int i=0; i<Q; i++){
//            int start=scanner.nextInt();
//            int end=scanner.nextInt();
//
//            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new ComparisonM());
//            pq.add(new Pair<>(start,0));
//
//            int[] minList = new int[n+1];
//            Arrays.fill(minList, Integer.MAX_VALUE);
//            minList[start]=0;
//            boolean[] visited = new boolean[n+1]; //确保每个节点都被遍历了就行了, 遍历过的不用遍历(没有负边)
//
//            while (!pq.isEmpty()){
//                Pair<Integer,Integer> pair = pq.poll(); //1.找出最近节点
//
//                visited[pair.point]=true;        //2.标记
//                for (Edge e:graph.get(pair.point)){ //3.更新minList
//                    if (!visited[e.to] && e.val+pair.val<minList[e.to]){
//                        minList[e.to]=e.val+pair.val;
//                        pq.add(new Pair<>(e.to, minList[e.to])); //pair的第二个值是到源点的距离
//                    }
//                }
//            }
//
//            res[i]= minList[end]==Integer.MAX_VALUE ? -1 : minList[end];
//            System.out.print(res[i]);
//            if (i<Q-1) System.out.print(" ");
//        }
//        scanner.close();
//    }
//}
