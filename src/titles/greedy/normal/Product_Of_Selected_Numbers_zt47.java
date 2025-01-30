package titles.greedy.normal;
import java.io.*;
import java.util.*;

public class Product_Of_Selected_Numbers_zt47 {
    static void solve() {
        long x = in.nextLong(), y = in.nextLong();
        int n = in.nextInt(), i, ans=0;
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for(i=0; i<n; i++){
            set.add(in.nextInt());
        }
        if(x>=y){
            out.println(0);
            return;
        }
        for(int s:set){
            x*=s;
            ++ans;
            if(x>=y){
                out.println(ans);
                return;
            }
        }
        out.println(-1);
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
