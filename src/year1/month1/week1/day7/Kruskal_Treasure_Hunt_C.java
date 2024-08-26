package year1.month1.week1.day7;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal_Treasure_Hunt_C {
    static int[] father;
    public static void main(String[] args) {
        //按权值排序, 然后用并查集添加边
        Scanner scanner = new Scanner(System.in);
        int v=scanner.nextInt();
        int e=scanner.nextInt();
        int[][] edges = new int[e][3];
        father=new int[v+1];
        for(int i=0; i<e; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            edges[i][0]=s;
            edges[i][1]=t;
            edges[i][2]=val;
        }
        Arrays.sort(edges,(a,b)->(a[2]-b[2]));
        System.out.println(Arrays.deepToString(edges));

        int count=0;
        Kruskal_Treasure_Hunt_C c = new Kruskal_Treasure_Hunt_C();
        c.init();
        for (int[] edge:edges){
            int s=edge[0];
            int t=edge[1];
            if (!c.isSame(s,t)){
                c.join(s,t);
                count+=edge[2];
            }
        }
        System.out.println(count);
    }

    void init(){
        for (int i=1; i<father.length; i++){
            father[i]=i;
        }
    }
    int find(int u){
        if (father[u]!=u){
            father[u]=find(father[u]);
        }
        return father[u];
    }
    boolean isSame(int u, int v){
        return find(u)==find(v);
    }
    void join(int u, int v){
        u=find(u);
        v=find(v);
        if (u!=v)father[v]=u;
    }
}

