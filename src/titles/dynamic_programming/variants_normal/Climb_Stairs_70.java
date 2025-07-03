package titles.dynamic_programming.variants_normal;

public class Climb_Stairs_70 {
}
class Solution_70 {
    // dp[i]为到i层有多少种方法
    // dp[0]=0
    // dp[i]=dp[i-1]+dp[i-2];
    // 也是斐波那契数列
    public int climbStairs(int n) {
        if (n<2) return n;
        int a = 1, b = 1;
        for (int i=2; i<=n; ++i) {
            int tmp = a+b;
            a = b;
            b = tmp;
        }
        return b;
    }
}