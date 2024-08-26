package year1.month1.week1.day7;

import java.util.Arrays;
import java.util.Scanner;

public class Prim_Treasure_Hunt_C {
    //1.找到最近节点
    //2.加入树
    //3.更新最短距离
    //minList: 该节点距离最小生成树的距离
    //计算结果从节点2开始计算, 因为节点1是10001
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //记得close
        int v=scanner.nextInt();
        int e=scanner.nextInt();
        int[][] grid = new int[v+1][v+1]; //用矩阵表示图
        for (int[] gr:grid){ //先填充最大距离,防止后续影响计算
            Arrays.fill(gr,10001);
        }
        for (int i=0; i<e; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            grid[s][t]=val;
            grid[t][s]=val;
        }

        int[] minList=new int[v+1];
        boolean[] tree = new boolean[v+1];
        int[] edges = new int[v+1];
        Arrays.fill(minList,10001);

        for (int i=1; i<=v; i++){ //其实不用遍历到最后一个的,因为最后一个的最短距离早在前一个确定后就生成了
            int cur=-1;
            int minVal=Integer.MAX_VALUE;

            //找到最近节点
            for (int j=1; j<=v; j++){
                if (!tree[j] && minList[j]<minVal){
                    minVal=minList[j];
                    cur=j;
                }
            }

            //加入树
            tree[cur]=true;

            //更新最短距离数组
            for (int k=1; k<=v; k++){
                if (!tree[k] && grid[cur][k]<minList[k]){
                    minList[k]=grid[cur][k];

                    edges[k]=cur; //保存边, 不能用cur作索引防止相同的cur被覆盖
                }
            }
        }

        int res = 0;
        for (int i=2; i<=v; i++){
            res+=minList[i];
        }
        System.out.println(res);
        for (int i=1; i<=v; i++){
            System.out.println(i+"->"+edges[v]);
        }
        scanner.close();
    }
}















//public class Treasure_Hunt_C {
//    static int[] father;
//    public static void main(String[] args) {
//        //按权值排序, 然后用并查集添加边
//        Scanner scanner = new Scanner(System.in);
//        int v=scanner.nextInt();
//        int e=scanner.nextInt();
//        int[][] edges = new int[e][3];
//        father=new int[v+1];
//        for(int i=0; i<e; i++){
//            int s=scanner.nextInt();
//            int t=scanner.nextInt();
//            int val=scanner.nextInt();
//            edges[i][0]=s;
//            edges[i][1]=t;
//            edges[i][2]=val;
//        }
//        Arrays.sort(edges,(a,b)->(a[2]-b[2]));
//        System.out.println(Arrays.deepToString(edges));
//
//        int count=0;
//        Treasure_Hunt_C treasureHuntC = new Treasure_Hunt_C();
//        treasureHuntC.init();
//        for (int[] edge:edges){
//            int s=edge[0];
//            int t=edge[1];
//            if (!treasureHuntC.isSame(s,t)){
//                treasureHuntC.join(s,t);
//                count+=edge[2];
//            }
//        }
//        System.out.println(count);
//    }
//
//    void init(){
//        for (int i=1; i<father.length; i++){
//            father[i]=i;
//        }
//    }
//    int find(int u){
//        if (father[u]!=u){
//            father[u]=find(father[u]);
//        }
//        return father[u];
//    }
//    boolean isSame(int u, int v){
//        return find(u)==find(v);
//    }
//    void join(int u, int v){
//        u=find(u);
//        v=find(v);
//        if (u!=v)father[v]=u;
//    }
//}

