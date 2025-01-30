package titles.dynamic_programming;
import java.util.*;
import java.io.*;

// dp[i][j]具体表示：字符串的前i个字符的方法数量，使得恰好有j个不匹配的(括号。
// 1. 当前为(时, 平衡增加1 dp[i][j]=dp[i-1][j-1] (j>0)   指示平衡增加了1所以把j-1的方法数继承过来(如dp[0][0]=1, dp[1][1]=dp[0][0]=1, 指示平衡多了1)
// 2. 当前为)时, 平衡减少1 dp[i][j]=dp[i-1][j+1] (j<n)    指示平衡减少了1所以把j+1的方法数继承过来(如dp[1][1]=1, dp[2][0]=dp[1][1]=1, 指示平衡少了1)
// 3. 当前为?时, 平衡增加1和减少1 dp[i]分别]=dp[i-1][j-1](j>0)+dp[i-1][j+1](j<n)
public class The_Number_Of_Legal_Parenthesis_Sequences_zt49 {
    static void solve(){
        String s = in.next();
        int n = s.length(), MOD=1000000007;
        int[][] dp = new int[n+1][n+1];
        dp[0][0]=1;
        for(int i=1; i<=n; i++){
            char c = s.charAt(i-1);
            for(int j=0; j<=n; j++){
                if(c=='('){
                    if(j>0)
                        dp[i][j]=dp[i-1][j-1];
                }else if(c==')'){
                    if(j<n)
                        dp[i][j]=dp[i-1][j+1];
                }else if(c=='?'){
                    if(j>0)
                        dp[i][j]=dp[i-1][j-1];
                    if(j<n)
                        dp[i][j]=(dp[i][j]+dp[i-1][j+1])%MOD;
                }
            }
        }
        out.print(dp[n][0]);
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
