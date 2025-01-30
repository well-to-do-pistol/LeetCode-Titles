package titles.dynamic_programming.knapsack_problem.template;
import java.util.*;
import java.io.*;

public class a_0_1_Knapsack_zt55 {
    static void solve(){
        int T=in.nextInt();
        for(int t=0; t<T; t++){
            int n=in.nextInt(), m=in.nextInt();

            //1. 二维解法
            // int[][] dp = new int[n+1][m+1]; //遍历物品和背包找到最大价值
            // for(int i=1; i<=n; i++){
            //     int size=in.nextInt();
            //     int val=in.nextInt();
            //     for(int j=0; j<=m; j++){
            //         if(j<size){
            //             dp[i][j]=dp[i-1][j];
            //         }else{
            //             dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-size]+val);
            //         }
            //     }
            // }

            //2. 一维解法, 因为只跟上一个有关, 所以可以压缩成一维
            int[] dp = new int[m+1];
            for(int i=1; i<=n; i++){
                int size=in.nextInt();
                int val=in.nextInt();
                for(int j=m; j>=size; j--){ //为什么for(int j=size; j<=m; j++)出错? 避免前面的物品重用; 并且j是一个一个减的, 肯定能把不同的价值叠加起来, 但是一个物品只能用一次, 只能从后往前遍历
                    dp[j]=Math.max(dp[j],dp[j-size]+val);
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
