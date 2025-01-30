package titles.number_theory;
import java.util.Scanner;

//代码的核心思想是通过质因数分解来计算出  𝑥 x 的质因数个数（包括重复的因数），然后根据质因数的总数的奇偶性来决定胜负
// 直接不断除以i, 计算次数, 奇数则kou赢
public class Prime_Factor_Game_zt36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x;
        int t=in.nextInt(),cnt,i;
        while(t-->0){
            x=in.nextLong();
            cnt=0;
            for(i=2; i<=Math.sqrt(x); i++){
                while(x%i==0){
                    cnt++;
                    x/=i;
                }
            }
            if(x!=1)cnt++;
            //用&浮点数和负数不可取
            System.out.println((cnt&1)==1? "kou":"yukari");
        }
    }

    // 判断素数的方法:
    // 1. 根号枚举, n<=1e12
    static boolean check(long n){
        if(n==1)
            return false;
        else if(n==2)
            return true;
        for(long i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    // 2. 素数筛选, n<=1e7
    static int N = 100100;
    static boolean[] b = new boolean[N];
    static void init(){
        b[0]=true;b[1]=true;
        for(int i=2; i<=Math.sqrt(N); i++){
            if(!b[i])
                //不能等于
                for(int j=i*i; j<N; j+=i)
                    b[j]=true;
        }
    }
    static boolean check2(int n){
        return !b[n];
    }
}
