package year1.month1.week1.day6;

class DSU{
    public int[] pre;
    public int[] Rank;

    public DSU(){
    }

    public DSU(int n){
        pre = new int[n+5];
        Rank = new int[n+5];
        for(int i=1;i<=n;++i){
            pre[i] = i;
            Rank[i] = 1;
        }
    }

    public int find(int x){
        if(pre[x]==x)
            return x;
        else
            return pre[x]=find(pre[x]);
    }

    public boolean equal(int x,int y){
        return find(x)==find(y);
    }

    public boolean merge(int x,int y){
        x=find(x);
        y=find(y);
        if(x==y)
            return false;
        else{
            if(Rank[x]>Rank[y])
                pre[y]=x;
            else{
                if(Rank[x]==Rank[y])
                    ++Rank[y];
                pre[x]=y;
            }
            return true;
        }
    }
}

public class Disjoint_Set_Template {
    int n=1005;
    int[] father = new int[n];
    //1.初始化
    public void init(){
        for (int i=0; i<n; i++){
            father[i]=i;
        }
    }
    //2.找根
    public int find(int u){
        if (father[u]!=u){
            father[u]=find(father[u]);
        }
        return father[u];
    }
    //3.判断是否同根?同一集合?
    public boolean isSame(int u, int v){
        u=find(u);
        v=find(v);
        return u==v;
    }
    //4.将两个元素加入同一集合
    public void join(int u, int v){
        u=find(u);
        v=find(v);
        if (u==v)return;
        father[v]=u;
     }
}
