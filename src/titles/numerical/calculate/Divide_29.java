package titles.numerical.calculate;
import java.util.*;
public class Divide_29 {
}
class Solution_29 {
    // 1. 最好的方法：
    // 先判断边界：被除数为最小整数，除数为-1，返回最大整数
    // 因为正负号，我们要将所有数统一符号，负数表示范围广所以是负数
    // 创建循环，判断是否大于等于0xc0000000（为-(1<<30),0x80000000为Integer.MIN_VALUE）
    // 例子15/2
    // 减8算出4，减4算出2，减2算出1，答案为4+2+1=7
    public int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE && divisor==-1)return Integer.MAX_VALUE;
        int negative = 2;
        if (dividend > 0){
            dividend = -dividend;
            --negative;
        }
        if (divisor > 0){
            divisor = -divisor;
            --negative;
        }
        int res = divideCore(dividend,divisor);
        return negative == 1 ? -res : res;
    }

    private int divideCore(int dividend, int divisor){
        int res = 0;
        while(dividend<=divisor){
            int val = divisor;
            int quotient = 1;
            while(val >= 0xc0000000 && dividend <= val+val){
                val+=val;
                quotient+=quotient;
            }
            res+=quotient;
            dividend-=val;
        }
        return res;
    }
}






///**
// *  二分查找
// *  二分法找出 x*y >= x 中 y所能满足的最大值, 用快速乘来解决乘法运算
// */
//class Solution { //-2147483648/2
//    public int divide(int dividend, int divisor) {
//        if (dividend==Integer.MIN_VALUE){
//            if (divisor==Integer.MIN_VALUE)return 1;
//            else if (divisor==-1)return Integer.MAX_VALUE;
//            else if (divisor==1)return Integer.MIN_VALUE;
//        }
//        if (divisor==Integer.MIN_VALUE){
//           return 0;
//        }
//        if (dividend==0)return 0;
//
//        boolean rev = false;
//        if (dividend>0){
//            dividend=-dividend;
//            rev=!rev;
//        }
//        if (divisor>0){
//            divisor=-divisor;
//            rev=!rev;
//        }
//        int ans=0;
//
//        int l=1, r=Integer.MAX_VALUE;
//        while (l<=r){
//            int m=l+((r-l)>>1);
//            boolean check = quickAdd(divisor,m,dividend);
//            if (check){
//                ans=m;
//                if (m==Integer.MAX_VALUE)break;
//                l=m+1;
//            }else {
//                r=m-1;
//            }
//        }
//        return rev ? -ans : ans;
//    }
//
//    private boolean quickAdd(int x, int y, int z) {
//        //x*y >= z , 就是要求满足条件的最大的y
//        int ans=0, contribute=x;          //快速幂里的是 x(底数), 这里底数也是x, 要乘以 y
//        while (y!=0){
//            if ((y&1)==1){                //因为每次都要加上一个负数, 只要这个等式不满足 x*y >= z就一定不满足
//                if (ans< z-contribute){   //注意要防溢出,下面也是
//                    return false;
//                }
//                ans+=contribute;
//            }
//            if (y!=1){ //已经移动到1, 贡献值*2也没用了
//                if (contribute<z-contribute){  //因为每次都要加上一个负数, 只要这个等式不满足 x*y >= z就一定不满足
//                    return false;
//                }
//                contribute+=contribute;
//            }
//            y>>=1; //右移一位相当于/2
//        }
//        return true;
//    }
//}
//
//
///**
// *  类二分查找
// *  用2*除数达到除数的较大倍数
// *  然后用被除数-除数的较大倍数, 累加贡献值的2的n次方
// */
//class Solution {
//    public int divide(int dividend, int divisor) {
//        if (dividend==Integer.MIN_VALUE){
//            if (divisor==Integer.MIN_VALUE)return 1;
//            else if (divisor==-1)return Integer.MAX_VALUE;
//            else if (divisor==1)return Integer.MIN_VALUE;
//        }
//        if (divisor==Integer.MIN_VALUE){
//            return 0;
//        }
//        if (dividend==0)return 0;
//
//        boolean rev=false;
//        if (dividend>0){
//            dividend=-dividend;
//            rev=!rev;
//        }
//        if (divisor>0){
//            divisor=-divisor;
//            rev=!rev;
//        }
//
//        List<Integer> candidates = new ArrayList<>();
//        candidates.add(divisor);
//        for (int i=0; candidates.get(i)>=dividend-candidates.get(i); ++i){
//            candidates.add(candidates.get(i)+candidates.get(i));
//        }
//        int ans=0;
//        for (int i= candidates.size()-1; i>=0; i--){
//            if (candidates.get(i)>=dividend){
//                ans+=1<<i;                      //按照贡献值进行 2的n次方附加
//                dividend-=candidates.get(i);
//            }
//        }
//        return rev ? -ans : ans;
//    }
//}