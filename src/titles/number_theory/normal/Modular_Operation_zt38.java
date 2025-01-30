package titles.number_theory.normal;
import java.util.Scanner;

// 订单是1基的, 模运算是0基的
// 就是订单x=m时, 会等于0, 实际应该等于x
// 所以可以先--, 再++
public class Modular_Operation_zt38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        long m,x;
        while(q-->0){
            m=in.nextLong();
            x=in.nextLong();
            x--;
            x%=m;
            x++;
            System.out.println(x);
        }
    }
}
