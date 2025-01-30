package titles.graph.dijkstra.variants_normal;
import java.util.*;
import java.io.*;
public class Most_Optimal_Path_In_Undirected_Weighted_Graph_zt45 {
    public static void main(String[] args) {
        solve();
        out.flush();
    }

    static void solve(){
        int n=in.nextInt(),m=in.nextInt(),q=in.nextInt(), u, w, v, weight, ver, i;
        long res=0;
        int[] tmp;
        List<int[]>[] graph = new ArrayList[n+5];
        for(i=1; i<=n; i++){
            graph[i]=new ArrayList<>();
        }
        int[] weights = new int[n+5];

        for(i=1; i<=m; i++){
            u=in.nextInt();
            v=in.nextInt();
            w=in.nextInt();
            graph[u].add(new int[]{w,v});
            graph[v].add(new int[]{w,u});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        queue.add(new int[]{0,1});
        Arrays.fill(weights,Integer.MAX_VALUE);
        weights[1]=0;
        while(!queue.isEmpty()){
            tmp=queue.poll();
            w=tmp[0];
            v=tmp[1];
            if(w>weights[v])
                continue;

            for(int[] edge:graph[v]){
                weight=edge[0];
                ver=edge[1];
                if(weight+w<weights[ver]){
                    weights[ver]=weight+w;
                    queue.add(new int[]{w+weight,ver});
                }
            }
        }

        for(i=1; i<=q; i++){
            res=res+weights[in.nextInt()]*2;
        }
        out.println(res);
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

/**
 * 最快的方法
 */
//import java.io.*;
//        import java.util.*;
//
//public class Main {
//    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//    static int N = (int)1e5+10, M = (int)2e5+10, idx = 0, n, m, Q;
//    static long INF = (long)1e18;
//    static int[] h = new int[N], e = new int[M], ne = new int[M], w = new int[M];
//    static long[] d = new long[N];
//    static boolean[] st = new boolean[N];
//    static PriorityQueue<PII> q = new PriorityQueue<>((o1, o2)->Long.compare(o1.len, o2.len));
//
//    public static int nextInt()throws IOException{
//        in.nextToken();
//        return (int)in.nval;
//    }
//
//    public static void add(int a, int b, int c){
//        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
//    }
//
//    public static void dijkstra(){
//        Arrays.fill(d, INF);
//        d[1] = 0;
//        q.add(new PII(1, 0));
//        while(!q.isEmpty()){
//            PII t = q.poll();
//            if(st[t.id]) continue;
//            st[t.id] = true;
//            for(int i=h[t.id]; i!=-1; i=ne[i]){
//                int j = e[i];
//                if(d[j]>d[t.id]+w[i]){
//                    d[j] = d[t.id]+w[i];
//                    q.add(new PII(j, d[j]));
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args)throws IOException{
//        n = nextInt(); m = nextInt(); Q = nextInt();
//        Arrays.fill(h, -1);
//        while(m-->0){
//            int a = nextInt(), b = nextInt(), c = nextInt();
//            add(a, b, c);   add(b, a, c);
//        }
//        dijkstra();
//        long ans = 0;
//        while(Q-->0) ans = ans+d[nextInt()]*2;
//        out.println(ans);
//        out.flush();
//        out.close();
//    }
//
//}
//
//class PII{
//    int id;
//    long len;
//    public PII(int id, long len){
//        this.id = id;
//        this.len = len;
//    }
//}