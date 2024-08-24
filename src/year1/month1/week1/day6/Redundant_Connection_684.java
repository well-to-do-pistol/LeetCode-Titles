package year1.month1.week1.day6;

public class Redundant_Connection_684 {
}
class Solution_684 {
    //思路: 根相同就输出--因为已经在同一集合, 再连起来就成环了所以要删除
    //从1开始
    int[] father;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        father=new int[n+1];
        initM(n);

        for (int i=0; i<n; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if (isSame(u,v))return edges[i];
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