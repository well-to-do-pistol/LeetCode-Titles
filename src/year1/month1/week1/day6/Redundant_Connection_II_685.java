package year1.month1.week1.day6;

import java.util.ArrayList;
import java.util.List;

public class Redundant_Connection_II_685 {
}
class Solution_685 {
    //判断删除边是否是有向树(并查集)
    //找到成环边(并查集)

    //情况1:找入度为2的边, (如果有两条, 倒序从边集合找)
    //情况2:没有入度为2的边, 说明已经成环, 删去成环的那条边

    int[] father;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        father=new int[n+1];
        initM(n);

        for (int i=0; i<n; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if (isSame(u,v))return new int[]{u,v};
            join(u,v);
        }
        return null;
    }

    private void initM(int n) {
        for (int i=1; i<n+1; i++){
            father[i]=i;
        }
    }

    private int find(int u){
        if (father[u]!=u){
            father[u]=find(father[u]);
        }
        return father[u];
    }

    private boolean isSame(int u, int v){
        return find(u)==find(v);
    }

    private void join(int u, int v){
        u=find(u);
        v=find(v);
        if (u==v)return;
        father[v]=u;
    }
}