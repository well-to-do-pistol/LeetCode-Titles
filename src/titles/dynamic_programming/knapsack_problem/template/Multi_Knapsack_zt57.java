package titles.dynamic_programming.knapsack_problem.template;
import java.util.*;
import java.io.*;

// 多重背包问题: 用二进制优化, 8个变成4个与1,2,4,1个此物品相同体积相同价值的物品. 然后变成01背包去解决(不是变成完全背包)
public class Multi_Knapsack_zt57 {
    static void solve(){
        int T=in.nextInt();
        for(int t=0; t<T; t++){
            int n=in.nextInt(), m=in.nextInt();
            long[] dp = new long[m+1];
            for(int i=1; i<=n; i++){
                int sum=0, bNum=1, remain=0; //这三个要在每个物品遍历时重置, 因为要将每个物品变成二进制物品
                int size=in.nextInt();
                int val=in.nextInt();
                int num=in.nextInt();
                while(sum+bNum<=num){
                    int tSize=bNum*size, tVal=bNum*val;
                    for(int j=m; j>=tSize; j--){
                        dp[j]=Math.max(dp[j],dp[j-tSize]+tVal);
                    }
                    sum+=bNum; //先加
                    bNum*=2;
                }
                remain=num-sum;
                if(remain>0){
                    int tSize=remain*size, tVal=remain*val;
                    for(int j=m; j>=tSize; j--){
                        dp[j]=Math.max(dp[j],dp[j-tSize]+tVal);
                    }
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
