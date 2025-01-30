package titles.dynamic_programming.knapsack_problem.template;
import java.util.*;
import java.io.*;

public class Full_Knapsack_zt56 {
    static void solve(){
        int T = in.nextInt();
        for(int t=0; t<T; t++){
            int n=in.nextInt(), m=in.nextInt();
            int[] dp = new int[m+1];
            for(int i=1; i<=n; i++){
                int size=in.nextInt(), val=in.nextInt();
                for(int j=size; j<=m; j++){
                    dp[j]=Math.max(dp[j], dp[j-size]+val);
                }
            }
            out.println(dp[m]);
        }
    }

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
