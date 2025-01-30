package titles.combinatorics;
import java.util.*;
import java.io.*;

public class The_Number_Of_Subsequences_Of_Even_Numbered_Characters_zt52 {
    static final int MOD = (int)(1e9+7);

    // 2的13次方分为 2的8次*2的4次*2的1次 (二进制数1101)
    // 即遇到1位, 把a乘到结果, 0位不乘(在这过程中, a等于2的n次)
    static long quickPow(long a, long b){
        long res=1;
        while(b>0){
            if((b&1)==1){
                res=(res*a)%MOD;
            }
            a=a*a%MOD;
            b>>=1;
        }
        return res;
    }

    static void solve(){
        String s = in.next();
        int[] counts = new int[26];
        for(char c1 : s.toCharArray()){
            ++counts[c1-'a'];
        }
        long res=1;
        for(int i:counts){
            if(i>1){
                res=res*quickPow(2,i-1)%MOD;
            }
        }
        out.println((res-1+MOD)%MOD);  //避免受到负数的影响; 空子序列（即不选任何字符）也满足条件，但题目要求的是非空子序列，因此需要减去 1。
    }

    /**
     1a 2a 3a , a的次数为3, 一共有2的3次种即8种组合
     0
     1a
     2a
     3a
     1a 2a
     1a 3a
     2a 3a
     1a 2a 3a      其中偶数组合有2的3-1次种即四种
     */

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
