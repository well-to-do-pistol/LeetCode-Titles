package titles.number_theory.prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Largest_Prime_Under_N_C {
    public static void main(String[] args) {
        Solution__c s = new Solution__c();
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i=10; i>=0; --i) {
            int j = random.nextInt(100);
            System.out.println("j="+j+". j's Prime = "+s.largestPrime(j));
        }
    }
}
class Solution__c {
    // 用sieve，埃氏筛得出boolean
    // 然后直接倒着判断返回
    public int largestPrime(int n) {
        if (n<2) return -1;

        boolean[] isPrime = sieve(n);
        for (int i=n; i>=2; --i) {
            if (isPrime[i])
                return i;
        }
        return -1;
    }

    // 从i*i开始标记为false，因为之前已经被更小的标记了。
    // 比如5*3 已经被3标记，5*4 已经被2标记
    // 然后+=i
    public boolean[] sieve(int n)  {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i=2; i<=n; ++i) {
            if (isPrime[i]) {
                for (int j=i*i; j<=n; j+=i) {
                    isPrime[j]=false;
                }
            }
        }
        return isPrime;
    }
}