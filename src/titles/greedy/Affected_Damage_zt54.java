package titles.greedy;
import java.util.*;
import java.io.*;

public class Affected_Damage_zt54 {
    static void solve(){
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i]=in.nextInt();
        }
        int ans = Integer.MAX_VALUE, x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;  //x是第一小的数, y是第二小的数
        for(int i=1; i<n; i++){                                                     //先计算只击打连续怪兽的情况
            if(a[i]<y){                                                             //更新x和y
                if(a[i]<x){
                    y=x;
                    x=a[i];
                }else
                    y=a[i];
            }
            int r = (a[i]+1)/2, l = a[i-1];                                         //r为当前血量/2的向上取整
            if(i==1)
                ans = Math.max(r,l);                                                //不要忘记第一种情况
            else
                ans = Math.min( ans, r>=l ? r : r+(l-r+1)/2);                            //r大于l则等于r; 小于时, 先用波及伤害杀死i, 再用波及伤害杀死i-1
        }
        out.println(Math.min(ans, x>=a[0] ? (x+1)/2+a[0] : (x+1)/2+(y+1)/2));        //还有a[0]为最小值的情况以及杀死怪兽不连续的情况
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
