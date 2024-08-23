package year1.month1.week1.day6;

public class Union_By_Rank_Template {
    //按秩合并(小树安在大树根), 并没有将树尽可能扁平化, 没有路径压缩(并查集那里)效率高
    //不能压缩路径(麻烦不讨好)

    int n=1005;
    int[] father = new int[n];
    int[] rank = new int[n];

    void init(){
        for (int i=0; i<n; i++){
            father[i]=i;
            rank[i]=1;
        }
    }

    int find(int u){
        if (father[u]!=u){
            return find(father[u]);
        }
        return u;
    }

    boolean isSame(int u, int v){
        return find(u)==find(v);
    }

    void join(int u, int v){
        u=find(u);
        v=find(v);

        if (u!=v){
            if (rank[u]<=rank[v]){ //比较等级, 等于小于的话变成根
                father[u]=v;
                if (rank[u]==rank[v])rank[v]++; //v变成了尾,降一级
            }else {
                father[v]=u;
            }
        }
    }
}


