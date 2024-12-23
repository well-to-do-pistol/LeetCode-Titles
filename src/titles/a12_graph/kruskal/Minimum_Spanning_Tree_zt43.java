package titles.a12_graph.kruskal;
import java.util.*;
import java.io.*;

// m条边, 按权重排序
// m条边, 加入并查集->如果不成环->1.加入答案权重; 2.加入答案边编号
public class Minimum_Spanning_Tree_zt43 {
    public static void main(String[] args) throws IOException{
        solve();
        out.flush();
    }
    static final int N = 500100;
    static T[] a = new T[N];
    static void solve(){
        int n=in.nextInt(), m=in.nextInt(), u,v,i;
        long w, ans=0;
        ArrayList<Integer> res = new ArrayList<>();
        for(i=1; i<=m; i++){
            u=in.nextInt();
            v=in.nextInt();
            w=in.nextLong();
            a[i]= new T(w,u,v,i);
        }
        Arrays.sort(a,1,m+1);
        DSU dsu = new DSU(n);
        for(i=1; i<=m; i++){
            if(dsu.merge(a[i].u,a[i].v)){
                ans+=a[i].w;
                res.add(a[i].i);
            }
        }
        out.println(ans);
        for(int edge:res){
            out.print(edge+" ");
        }
    }

    static class T implements Comparable<T>{
        long w;
        int u;
        int v;
        int i;
        T(long w, int u, int v, int i){
            this.w=w;
            this.u=u;
            this.v=v;
            this.i=i;
        }
        @Override
        public int compareTo(T t){
            return Long.compare(this.w,t.w);
        }
    }

    //Disjoint Set Union
    static class DSU{
        int[] pre;
        int[] rank;
        DSU(int n){
            pre=new int[n+5];
            rank=new int[n+5];
            for(int i=1; i<=n; i++){
                pre[i]=i;
                rank[i]=1;
            }
        }
        int find(int x){
            if(pre[x]==x)
                return x;
            return pre[x]=find(pre[x]);
        }
        boolean equal(int x, int y){
            return find(x)==find(y);
        }
        boolean merge(int x, int y){
            x=find(x);
            y=find(y);
            if(x==y)
                return false;
            if(rank[x]>rank[y]){
                pre[y]=x;
            }else{
                if(rank[x]==rank[y])
                    ++rank[y];
                pre[x]=y;
            }
            return true;
        }
    }

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class FastReader{
        private BufferedReader br;
        private StringTokenizer st;
        FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            String str="";
            while(st==null || !st.hasMoreElements()){
                try{
                    str=br.readLine();
                }catch(IOException e){
                    throw new RuntimeException(e);
                }
                st=new StringTokenizer(str);
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}
