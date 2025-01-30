package titles.other.counting;
import java.util.*;
import java.io.*;
// 一个比lBound小的数会增加lOver和rBal的值, 所以最好有小于出界的数和大于出界的数两两匹配. 但结果等于lOver和rOver的最大值因为使用最佳的两两匹配绝对能配完较小值, 剩下的次数就是给最大值了.
// 1. 如果 `a` 小于 `left`，则将差值 `left - a` 添加到 `leftDistance`，因为需要增加它才能至少到达 `left`。
// 2. 如果 `a` 大于 `left`，则它贡献给 `l`（可用于平衡 `leftDistance` 的超额部分）。
// 3. 如果 `a` 大于 `right`，则将差值 `a - right` 添加到 `rightDistance`，因为需要减少它才能最多到达 `right`。
// 4. 如果 `a` 小于 `right`，则它贡献给 `r`（可用于平衡 `rightDistance` 的超额部分）。
public class Element_Modify_zt51 {
    static void solve(){
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int lBound=in.nextInt();
            int rBound=in.nextInt();
            long lOver=0, rOver=0, lBal=0, rBal=0;
            while(n-->0){
                int a = in.nextInt();
                if(a<lBound)
                    lOver+=lBound-a;
                else
                    lBal+=a-lBound;
                if(a>rBound)
                    rOver+=a-rBound;
                else
                    rBal+=rBound-a;
            }
            if(lOver>lBal || rOver>rBal)
                out.println(-1);
            else
                out.println(Math.max(lOver,rOver));
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
