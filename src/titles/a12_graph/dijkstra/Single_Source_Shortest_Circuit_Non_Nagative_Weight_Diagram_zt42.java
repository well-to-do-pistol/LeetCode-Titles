package titles.a12_graph.dijkstra;
import java.util.*;
import java.io.*;

public class Single_Source_Shortest_Circuit_Non_Nagative_Weight_Diagram_zt42 {
    public static void main(String[] args) throws IOException{
        solve();
        out.flush();
    }

    static final int N=500100;
    static ArrayList<Edge>[] e = new ArrayList[N];
    static long[] b = new long[N];

    static void solve(){
        int n=in.nextInt(), m=in.nextInt(), s=in.nextInt(),u,v;
        long w;
        for(int i=1; i<=n; i++)
            e[i]=new ArrayList<>();
        while(m-->0){
            u=in.nextInt();
            v=in.nextInt();
            w=in.nextLong();
            e[u].add(new Edge(w,v));
        }
        Arrays.fill(b,Long.MAX_VALUE);
        bfs(s);
        for(int i=1; i<=n; i++){
            out.print((b[i]==Long.MAX_VALUE?-1:b[i])+" ");
        }
    }

    static void bfs(int now){
        Edge tmp;
        Queue<Edge> queue = new PriorityQueue<>();
        b[now]=0;
        long weight,w;
        int point,p;
        queue.add(new Edge(0,now));
        while(!queue.isEmpty()){
            tmp=queue.poll();
            weight=tmp.weight;
            point=tmp.point;
            if(b[point]!=weight)
                continue;
            for(Edge edge:e[point]){
                w=edge.weight;
                p=edge.point;
                if(b[p]>w+weight){
                    b[p]=w+weight;
                    queue.add(new Edge(w+weight,p));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        long weight;
        int point;
        Edge(long weight, int point){
            this.weight=weight;
            this.point=point;
        }
        @Override
        public int compareTo(Edge e){
            if(this.weight==e.weight){
                return Integer.compare(this.point,e.point);
            }
            return Long.compare(this.weight,e.weight);
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
            while(st==null||!st.hasMoreElements()){
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
