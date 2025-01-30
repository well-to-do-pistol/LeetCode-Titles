package titles.graph.bfs;
import java.util.*;
import java.io.*;

// 队列记录Edge(距离, 点)
// 数组记录最终结果(起点到每个点的距离)
// 数组记录每条边(邻接表)
public class Single_Source_Shortest_Circuit_Unauthorized_Diagram_zt41 {
    public static void main(String[] args) throws IOException {
        solve();
        out.flush();
    }

    static final int N = 2000100;
    static ArrayList<Integer>[] e = new ArrayList[N];
    static int[] b = new int[N];
    static void solve(){
        int n=in.nextInt(), m=in.nextInt(), s=in.nextInt(), i;
        for(i=1; i<=n; i++){
            e[i]=new ArrayList<>();
        }
        while(m-->0){
            e[in.nextInt()].add(in.nextInt());
        }
        Arrays.fill(b,Integer.MAX_VALUE);
        bfs(s);
        for(i=1; i<=n; i++){
            out.print((b[i]==Integer.MAX_VALUE?-1:b[i])+" ");
        }
    }

    static void bfs(int now){
        Edge tmp;
        int dis,point;
        Queue<Edge> queue = new LinkedList();
        b[now]=0;
        queue.add(new Edge(0,now));
        while(!queue.isEmpty()){
            tmp=queue.poll();
            dis=tmp.dis;
            point=tmp.point;
            if(b[point]!=dis)
                continue;
            for(int nextPoint:e[point]){
                if(b[nextPoint]>dis+1){
                    b[nextPoint]=dis+1;
                    queue.add(new Edge(dis+1,nextPoint));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int dis;
        int point;
        Edge(int dis, int point){
            this.dis=dis;
            this.point=point;
        }
        @Override
        public int compareTo(Edge e){
            if(this.dis==e.dis)
                return Integer.compare(this.point,e.point);
            return Integer.compare(this.dis,e.dis);
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
