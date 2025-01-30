package titles.graph.dsu.variants;
import java.util.*;
import java.io.*;

// 组合公式: C(n,2)= n!/(n-2)!*2!化简得到 n(n-1)/2
// 构建图, 如果边两头都为字串为1的节点, 把它们加进DSU
// 遍历所有字串为1的节点的父节点计算总收益
// 遍历所有字串为0的节点, 看它们相邻的点(相邻的必须字串为1)的父, 计算最大收益, 把这些父放进set防止重复
public class Optimizing_Total_Benefits_In_A_Network_Of_Cities_Connected_By_Roads_zt46 {
    public static void main(String[] args) {
        solve();
        out.flush();
    }

    static void solve(){
        int n=in.nextInt(),m=in.nextInt(), u, v, i, p, bestPos=-1, sum, tmp;
        long total=0, cur, maxVal=0;
        List<Integer>[] graph = new ArrayList[n+5];
        for(i=1; i<=n; i++){
            graph[i]=new ArrayList<>();
        }
        String s = in.next();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[n+5];
        DSU dsu = new DSU(n);
        for(i=1; i<=m; i++){
            u=in.nextInt();
            v=in.nextInt();
            graph[u].add(v);
            graph[v].add(u);
            if(chars[u-1]=='1'&&chars[v-1]=='1'){
                dsu.merge(u,v);
            }
        }
        for(i=1; i<=n; i++){
            if(chars[i-1]=='1'){
                p=dsu.find(i);
                if(!visited[p]){
                    tmp=dsu.size(p);
                    total+=tmp*(tmp-1)/2;
                    visited[p]=true;
                }
            }
        }
        for(i=1; i<=n; i++){
            if(chars[i-1]=='0'){
                cur=total;
                sum=1;
                Set<Integer> set = new HashSet<>();
                for(int j : graph[i]){
                    if(chars[j-1]=='1'){
                        p=dsu.find(j);
                        if(!set.contains(p)){
                            tmp=dsu.size(p);
                            sum+=tmp;
                            cur-=(long)tmp*(tmp-1)/2;
                            set.add(p);
                        }
                    }
                }
                cur+=sum*(sum-1)/2;
                if(cur>maxVal){
                    maxVal=cur;
                    bestPos=i;
                }
            }
        }
        out.println(bestPos+" "+maxVal);
    }

    static class DSU{
        int[] p;
        int[] sizes;
        int[] levels;
        DSU(int n){
            p=new int[n+5];
            sizes=new int[n+5];
            levels=new int[n+5];
            for(int i=1; i<=n; i++){
                p[i]=i;
                sizes[i]=1;
                levels[i]=1;
            }
        }
        int find(int x){
            while(x!=p[x]){
                x=p[x]=p[p[x]];
            }
            return x;
        }

        //查看相同一定要找父节点顺便压缩而不是只找父节点
        boolean isSame(int x, int y){
            return find(x)==find(y);
        }
        boolean merge(int x, int y){
            x=find(x);
            y=find(y);
            if(x==y)
                return false;
            if(levels[y]>levels[x]){
                p[x]=y;
                sizes[y]+=sizes[x];
            }else{
                if(levels[x]==levels[y])
                    ++levels[x];
                p[y]=x;
                sizes[x]+=sizes[y];
            }
            return true;
        }

        //计算大小一定要先找父节点
        int size(int x){
            return sizes[find(x)];
        }
    }

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class FastReader{
        static BufferedReader br;
        static StringTokenizer st;

        FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            String str="";
            while(st==null || !st.hasMoreElements()){
                try{
                    str = br.readLine();
                }catch(IOException e){
                    throw new RuntimeException(e);
                }
                st = new StringTokenizer(str);
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
