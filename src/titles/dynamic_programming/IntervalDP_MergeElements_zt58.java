package titles.dynamic_programming;
import java.util.*;
import java.io.*;

//区间dp, dp[i][j]表示从索引i到j的最优解(最小合并代价)
//length: 控制当前要处理的区间长度
//i: 控制区间的起始位置
//k: 尝试不同的分割点，找出最优解
public class IntervalDP_MergeElements_zt58 {
    static void solve(){
        int n=in.nextInt();
        int[] a = new int[n+1];
        int[] sum = new int[n+1]; //前缀和
        long[][] dp = new long[n+1][n+1];
        for(int i=1; i<=n; i++){
            int tmp = in.nextInt();
            a[i]=tmp;
            sum[i]=tmp+sum[i-1];
            dp[i-1][i]=tmp+a[i-1];
        }
        dp[0][1]=0;
        for(int length=3; length<=n; length++){
            for(int i=1; i<=n-length+1; i++){ //索引起始点
                int j=i+length-1;             //索引终点
                dp[i][j]=Long.MAX_VALUE;
                for(int k=i; k<j; k++){       //分割点
                    dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);  //这里是最小代价
                }
                dp[i][j]+=(sum[j]-sum[i-1]);                             //总代价等于最小代价+总和
            }
        }
        out.println(dp[1][n]);
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
