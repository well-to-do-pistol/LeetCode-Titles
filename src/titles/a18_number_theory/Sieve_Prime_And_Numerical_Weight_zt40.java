package titles.a18_number_theory;
import java.util.*;

//素数筛选加预处理, Sieve of Eratosthenes with Precomputation
public class Sieve_Prime_And_Numerical_Weight_zt40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), x, res;
        init();
        while (t-- > 0) {
            x = in.nextInt();
            List<Pair> v = query(x);
            res=1;
            //当`x` 为素数幂时, +1为`x` 的除数数量, 这里是*2
            // 当 `x` 有多个不同的素因数时，for(Pair r:v){ res*=r.second+1; }表示 `x` 的除数数量
            if(v.size()==1){
                res=2*(v.get(0).second);
            }else if(v.size()>1){
                for(Pair r:v){
                    res*=r.second+1;
                }
            }
            System.out.println(res);
        }
    }

    static final int N =200100;
    static boolean[] b = new boolean[N];
    //d1[j]：存储数字 `j`的最小素因数
    //d2[j]：存储数字 `j`的最大素因数
    //拥有最小和最大素因数可以让您高效地计算各种数论函数，例如除数的数量、素因数分解等。
    static int[] d1 = new int[N];
    static int[] d2 = new int[N];

    static void init(){
        int m = (int)Math.sqrt(N+2)+2, i, j;
        b[0]=true;
        b[1]=true;
        for(i=2; i<=m; i++){
            if(!b[i])
                for(j=i*i; j<N; j+=i)
                    b[j]=true;
        }
        List<Integer> c = new ArrayList<>();
        for(i=2; i<N; i++)
            if(!b[i])c.add(i);
        for(int x:c)
            for(j=x; j<N; j+=x){
                if(d1[j]==0)
                    d1[j]=x;
                d2[j]=x;
            }
    }

    /**
     分解n拿到它的素因数以及对应的指数, 如:
     n=60 {2,2} -> 变成30 {3,1} -> 变成5 {5,1} ; 拿到数组v {{2,2},{3,1},{5,1}};
     n=16 {2,4}
     */
    static List<Pair>  query(int n){
        List<Pair> v = new ArrayList<>();
        int res,cnt;
        while(n>1){
            cnt=0;
            for(res=d1[n]; n%res==0; n/=res){
                cnt++;
            }
            v.add(new Pair(res,cnt));
        }
        return v;
    }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.first==p2.first){
                return Integer.compare(this.second,p2.second);
            }
            return Integer.compare(this.first,p2.first);
        }
    }
}
