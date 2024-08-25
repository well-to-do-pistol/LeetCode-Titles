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

    //    1                    1
    //   /  \                 /  \
    //  2 -- 3          4 -- 2 -- 3

    int[] father;
    int[] degree;
    List<int[]> removes;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        degree = new int[n+1];
        father = new int[n+1];
        removes = new ArrayList<>();

        //计算入度
        for (int[] edge:edges){
            int t=edge[1];
            degree[t]++;
        }

        //从后向前遍历
        for (int i=n-1; i>=0; i--){
            int s=edges[i][0];
            int t=edges[i][1];
            if (degree[t]==2){
                removes.add(new int[]{s,t});
            }
        }

        //三种情况
        if (!removes.isEmpty()){
            if (tree_after_remove(edges, removes.get(0))){
                return new int[]{removes.get(0)[0], removes.get(0)[1]};
            }else {
                return new int[]{removes.get(1)[0], removes.get(1)[1]};
            }
        }else {
            return no_degree_circle(edges);
        }
    }

    private int[] no_degree_circle(int[][] edges) {
        initM(edges.length);//每次都要初始化
        for (int[] edge:edges){
            int s=edge[0];
            int t=edge[1];
            if (isSame(s,t))return new int[]{s,t};
            join(s,t);
        }
        return null;
    }

    private boolean tree_after_remove(int[][] edges, int[] remove) {
        initM(edges.length); //每次都要初始化
        for (int[] edge:edges){
            int s=edge[0];
            int t=edge[1];
            if (s==remove[0] && t==remove[1])continue;
            join(s,t);
        }
        return isSame(remove[0],remove[1]);
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