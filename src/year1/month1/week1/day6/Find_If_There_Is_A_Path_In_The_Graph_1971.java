package year1.month1.week1.day6;

public class Find_If_There_Is_A_Path_In_The_Graph_1971 {
}
class Solution_1971 {
    int[] father;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        father=new int[n];
        initM(n);

        for (int i=0; i<edges.length; i++){
            join(edges[i][0],edges[i][1]);
        }

        return isSame(source, destination);
    }

    private void initM(int n) {
        for (int i=0; i<n; i++){
            father[i]=i;
        }
    }

    private int find(int u){//压缩路径
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