package titles.number_theory;
import java.util.Scanner;

/**
 x=2,y=4,z=3
 2^4=2^2 * 2^2
 y
 4   x=x*x
 2   x=x*x * x*x
 1   得到ans了
 0
 只在y的二进制为1的位上将结果加到ans, 每次计算都适应一次z
 */
public class Fast_Power_Fast_Modular_Exponentiation_zt37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        long x,y,z;
        while(t-->0){
            x=in.nextLong();
            y=in.nextLong();
            z=in.nextLong();
            System.out.println(fme(x,y,z));
        }
    }

    //Fast Modular Exponentiation快速模幂运算
    static long fme(long x, long y, long z){
        //防止z等于1, 任何数模1等于0
        long ans=1%z;
        //使x适应z, 当x比z大时, 如x=4,z=3
        x%=z;
        //防止x为负数
        x=(x+z)%z;
        while(y!=0){
            if(y%2==1){
                ans=ans*x%z;
            }
            x=x*x%z;
            y/=2;
        }
        return ans;
    }

    //乘法逆元
    /**
     * 给定a,b,p, 求出a/b在模p意义下的值
     * 题目一般会把p设置为一个素数
     * 值为 a*fme(b,p-2,p)%p
     *
     * 在普通的乘法运算中3*(1/3)=1, (1/3)就是3的乘法逆元。
     * 对于模7的情况来说, 3*5 % 7 =1, 5就是3的乘法逆元
     */
    static long inv(long b, long p){
        return fme(b,p-2,p);
    }
}
