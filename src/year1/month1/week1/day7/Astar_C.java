package year1.month1.week1.day7;

import java.util.*;

//写了A*和广搜两种方法



public class Astar_C {
    //只适用明确的终点(多个终点不行)
    //用启发式函数计算当前点到终点的距离(欧拉距离)得到h, 用f=g+h 来决定出距离终点方向最近的那些点才加入优先队列
    //只有当前点是0才+1, 因为这相当于优化广搜, 第一次肯定是最优

    static int b1,b2;
    static class Knight{ //f表示源点到终点距离, g表示源点到当前点距离, h表示当前点到终点距离
        int x,y;
        int f,g,h;
        public Knight(int x, int y, int g){
            this.x=x;
            this.y=y;
            this.g=g;
            h=heuristic(x,y);
            f=g+h;
        }
    }
    private static int heuristic(int x, int y) { //启发式函数
        return (x-b1)*(x-b1)+(y-b2)*(y-b2);
    }



    static int[][] direction = {{1,2},{2,1},{1,-2},{2,-1},{-1,-2},{-2,-1},{-1,2},{-2,1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] move = new int[10001][1001];
        int n=scanner.nextInt();
        for (int i=0; i<n; i++){
            int a1=scanner.nextInt();
            int a2=scanner.nextInt();
            b1=scanner.nextInt();
            b2=scanner.nextInt();

            for (int[] m:move) Arrays.fill(m,0); //每次清0

            Knight start=new Knight(a1,a2,0);
            astart(start, move);

            System.out.println(move[b1][b2]); //源点最短距离
        }
        scanner.close();
    }

    private static void astart(Knight start, int[][] move) {
        PriorityQueue<Knight> queue = new PriorityQueue<>((a,b)->(a.f-b.f));
        queue.add(start);

        while (!queue.isEmpty()){
            Knight cur = queue.poll();
            int x1=cur.x;
            int x2=cur.y;

            if (x1==b1 && x2==b2)break;

            for (int[] dir:direction){
                int y1=x1+dir[0];
                int y2=x2+dir[1];
                if (y1<1 || y1>1000 || y2<1 || y2>1000)continue;
                if (move[y1][y2]==0){ //只有等于0才更新, 因为广搜的结果肯定是最近的
                    move[y1][y2]=move[x1][x2]+1;
                    //不加上之前的g的话, 小于2步的情况, 每一次的步数都多了2, 因为距离远的话看不出差别因为路径都是直线
                    //但是到了终点附近, 距离源点近的点就吃亏了, h相同的话, 有插队的排进了队列就导致步数增多
                    Knight next = new Knight(y1,y2,cur.g+5); //注意!!!要将之前的加上, 骑士的特殊走路的绝对距离为5, 1*1+2*2
                    queue.add(next);
                }
            }
        }
    }
}






//public class Astar_C {
//    //广搜(有点Dijkstra的意思), 以起点为中心, 直到找到终点
//    //每次都要刷新minList
//    static int[][] direction = {{1,2},{2,1},{1,-2},{2,-1},{-1,-2},{-2,-1},{-1,2},{-2,1}};
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[][] move = new int[10001][1001];
//        int n=scanner.nextInt();
//        for (int i=0; i<n; i++){
//            int a1=scanner.nextInt();
//            int a2=scanner.nextInt();
//            int b1=scanner.nextInt();
//            int b2=scanner.nextInt();
//
//            for (int[] m:move) Arrays.fill(m,0); //每次清0
//
//            bfs(a1,a2,b1,b2,move);
//
//            System.out.println(move[b1][b2]); //源点最短距离
//        }
//
//        scanner.close();
//    }
//
//    private static void bfs(int a1, int a2, int b1, int b2, int[][] move) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(a1);
//        queue.add(a2);
//
//        while (!queue.isEmpty()){
//            int x1=queue.poll();
//            int x2=queue.poll();
//
//            if (x1==b1 && x2==b2)break;
//
//            for (int[] dir:direction){
//                int y1=x1+dir[0];
//                int y2=x2+dir[1];
//                if (y1<1 || y1>1000 || y2<1 || y2>1000)continue;
//                if (move[y1][y2]==0){ //只有等于0才更新, 因为广搜的结果肯定是最近的
//                    move[y1][y2]=move[x1][x2]+1;
//                    queue.add(y1);
//                    queue.add(y2);
//                }
//            }
//
//        }
//    }
//}
