package titles.number_theory;

import  java.util.*;

public class Lowest_Common_Multiple_zt35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n,a,b;
        int t = in.nextInt();
        while(t-->0){
            n=in.nextLong();
            a=n/2;
            b=n-a;
            while(gcd(a,b)!=1){
                a--;
                b++;
            }
            System.out.println(a+" "+b);
        }
    }

    //greatest common divisor最大公约数, 利用辗转相除法
    static long gcd(long a, long b){
        long n;
        while(b!=0){
            n=a%b;
            a=b;
            b=n;
        }
        return a;
    }

    //lowest common multiple最小公倍数
    static long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }//相乘除去最大公约数
}
