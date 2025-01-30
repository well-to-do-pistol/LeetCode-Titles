package titles.dynamic_programming;
import java.util.*;
import java.io.*;


public class TreeShapedDP_TreeColoring_zt50 {
    /**
     * 1. 最快方法
     */
    static int[] a;
    static ArrayList<Integer>[] e;
    static void solve(){
        int n = in.nextInt();
        a = new int[n+1];
        e = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            a[i]=in.nextInt();
            e[i]=new ArrayList();
        }
        for(int i=1; i<n; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            e[u].add(v);
            e[v].add(u);
        }
        vis = new int[n+1];
        dfs(1,0);
        out.println(ans);
    }

    static long ans=0;
    static int[] vis;
    static void dfs(int u, int fa){
        for(int v:e[u]){
            if(v==fa)continue;
            dfs(v,u);
            if(vis[u]==1 || vis[v]==1)continue;
            long tmp = a[u]*a[v];
            long t = (long)Math.sqrt(tmp);
            if(t*t==tmp){
                ans+=2;
                vis[v]=1;
                vis[u]=1;
            }
        }
    }

    /**
     * 2. 树形dp, 稍微慢了一点.
     */
    //dfs中:
    //第一个循环确保我们收集有关以`u`为根的子树的信息。(更新f[u][0])
    //第二个循环使用此信息来决定将`u`及其子节点之一染成红色是否是最佳选择。(更新f[u][1])
//    static int[] a;
//    static ArrayList<Integer>[] e;
//    static int[][] f;
//
//    static void solve(){
//        int n = in.nextInt();
//        a = new int[n+1];
//        e = new ArrayList[n+1];
//        f = new int[n+1][2];
//        for(int i=1; i<=n; i++){
//            a[i]=in.nextInt();
//            e[i]=new ArrayList();
//        }
//        for(int i=1; i<n; i++){
//            int u = in.nextInt();
//            int v = in.nextInt();
//            e[u].add(v);
//            e[v].add(u);
//        }
//        dfs(1,0);
//        out.println(Math.max(f[1][0],f[1][1]));
//    }
//
//    static void dfs(int u, int fa){
//        for(int v:e[u]){
//            if(v==fa)
//                continue;
//            dfs(v,u);
//            f[u][0]+=Math.max(f[v][1],f[v][0]);
//        }
//        for(int v:e[u]){
//            if(v==fa)
//                continue;
//            long tmp = a[u]*a[v];
//            long t = (long)Math.sqrt(tmp);
//            if(t*t==tmp){
//                f[u][1]=Math.max(f[u][1], f[u][0]-Math.max(f[v][1],f[v][0])+2+f[v][0]);   //如果当前节点染色, 则f[u][1]只能等于2+子节点不染色的情况数
//            }
//        }
//    }

    public static void main(String[] args) {
        solve();
        out.flush();
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
