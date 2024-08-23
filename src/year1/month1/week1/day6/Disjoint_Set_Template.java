package year1.month1.week1.day6;

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
