package titles.dynamic_programming.jumpgame;
import java.util.*;
import java.io.*;
public class Jump_Game_Four_Types_of_Cards_zt53 {
    /**
     1. 最快方法
     */
//     static int[] a = new int[10];
//     static void solve(){
//         int n = in.nextInt();
//         long ans = 0;
//         for(int i=0; i<n; i++){
//             a[i%10] = in.nextInt();
//             if(i%10==9 || i+1==n){
//                 ans = get_answer(ans);
//                 if(ans==-1){
//                     out.println(-1);
//                     return;
//                 }
//                 a = new int[10];
//             }
//         }
//         out.println(ans);
//     }

// //枚举前两步即i和j的所有可能, 传入success计算选择剩下两步的最大值. 最后计算总四步所有方案的最大值
//     static long get_answer(long ans){
//         long max=0;
//         boolean finish = false;
//         for(int i=1; i<=4; i++){
//             for(int j=1; j<=4; j++){
//                 if(i==j)continue;
//                 long t = success(i,j,ans);
//                 if(t<0)continue;
//                 else{
//                     max=Math.max(t,max);
//                     if(!finish)finish=true;
//                 }
//             }
//         }
//         if(finish)return max;
//         return -1;
//     }

// //以i和j的基础枚举剩下1步的所有可能取最大值, 最后一步必是拿a[9]的金币
//     static long success(int i, int j, long ans){
//         int now = i-1;
//         long t=ans;
//         t += a[now];
//         if(t<0)return -1;
//         now = now+j;
//         t += a[now];
//         if(t<0)return -1;
//         if(i+j!=5)t+=Math.max(a[now+5-i],a[now+5-j]);
//         else if(i==1 || j==1)t+=Math.max(a[now+2],a[now+3]);
//         else
//             t+=Math.max(a[now+1],a[now+4]);
//         if(t<0)return -1;
//         t+=a[9];
//         return t;
//     }

//---------------------------------------------------------------------------

    /**
     2. 动态规划

     1. 遍历所有可能的卡牌使用状态（x）。
     2. 对于每种状态，检查是否可以使用某张卡牌（j）。
     3. 如果可以使用某张卡牌，并且从跳跃前的城市到达当前城市是可行的，则更新当前城市和状态下的最大金币数量。
     (对于每个城市i（从1到n），遍历所有可能的卡牌使用状态x（从0到15，因为4张卡牌的状态可以用4位二进制表示，共16种状态）。)
     */
    static void solve(){
        int n=in.nextInt();
        int[] a = new int[n+1];
        long[][] dp = new long[n+1][16];
        for(int i=1; i<=n; i++){
            a[i]=in.nextInt();
            Arrays.fill(dp[i],-1);  //要全设为-1, 避免从不是0城市跳跃
        }
        Arrays.fill(dp[0],-1);
        dp[0][0]=0;
        for(int i=1; i<=n; i++){
            for(int x=0; x<16; x++){
                for(int j=0; j<4; j++){
                    if(((x>>j)&1)==1 && i-j-1>=0 && dp[i-j-1][x^(1<<j)]>=0){  //将状态x的第j位取反，表示未使用第j张卡牌的状态。
                        dp[i][x]=Math.max( dp[i][x], dp[i-j-1][x^(1<<j)] + a[i] );  //表示从城市i - j - 1到达城市i之前的状态和最大金币数量。
                    } //如果x为0100, 那么就要取dp[i-j-1][0000]--相当于在该位置算出最大金币后, 选择了跳j+1步来到i城市
                }
            }
            if(i%10==0){
                dp[i][0]=dp[i][15]; //每10个更新一下dp[i][0]让后面能够利用前面的算出来的值
            }
        }
        long ans=-1;
        for(int i=0; i<16; i++){
            ans=Math.max(ans,dp[n][i]);
        }
        out.println(ans>=0?ans:-1);
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
