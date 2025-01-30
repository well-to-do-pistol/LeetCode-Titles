package titles.graph.dijkstra.variants;
import java.util.*;
import java.io.*;

// 图是无向图(两端都要加对应边), 用int[3]代表w,v,h(w和h要防溢出吗?不用,两个小于1e9的数相加不会超出)
// PriorityQueue放int[3], graph也是
// 循环队列弹出int[3], 只有w大于等于weights才能继续, 遍历起点对应的边, 最终距离只有小于h才能继续, 用Math.min取得最新权重后大于weights里的权重才能更新weights和添加到queue
public class Most_Optimal_Path_Under_Constraints_In_Undirected_Weighted_Graph_zt44 {
    public static void main(String[] args) {
        solve();
        out.flush();
    }

    static void solve(){
        int n=in.nextInt(),m=in.nextInt(),h=in.nextInt(), u, v, w, d, weight, ver, dit, newWeight;
        int[] tmp;
        List<int[]>[] graph = new ArrayList[n+5];
        for(int i=1; i<=n; i++){
            graph[i]=new ArrayList<>();
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int[] weights = new int[n+5];
        for(int i=1; i<=m; i++){
            u=in.nextInt();
            v=in.nextInt();
            w=in.nextInt();
            d=in.nextInt();
            graph[u].add(new int[]{w,v,d});
            graph[v].add(new int[]{w,u,d});
        }
        Arrays.fill(weights,Integer.MIN_VALUE);
        weights[1]=Integer.MAX_VALUE;
        queue.add(new int[]{-Integer.MAX_VALUE,1,0});
        while(!queue.isEmpty()){
            tmp=queue.poll();
            w=-tmp[0];
            v=tmp[1];
            d=tmp[2];
            if(w<weights[v])
                continue;
            for(int[] edge:graph[v]){
                dit=edge[2];
                if(d+dit>h)
                    continue;
                weight=edge[0];
                ver=edge[1];
                newWeight=Math.min(w,weight);
                if(newWeight>weights[ver]){
                    weights[ver]=newWeight;
                    queue.add(new int[]{-newWeight,ver,d+dit});
                }
            }
        }
        out.println(weights[n]==Integer.MIN_VALUE?-1:weights[n]);
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
