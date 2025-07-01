package titles.dynamic_programming.spelling_number_0_1_backpack;

public class Integer_Break_343 {
}
class Solution_343 {
    // 1. 不是最优，动态
    // 拆成尽可能多并接近的数，先物品后背包，数为物品重量，数为背包容量
    // dp[i]为i所拆数的最大乘积
    // dp[0-1] = 1
    // 状态转移方程分为拆成2个数或拆成多个数--i*dp[i-j]一定是多个数
    // dp[i] = max(i*(i-j),i*dp[i-j])
    // public int integerBreak(int n) {
    //     int[] dp = new int[n+1];
    //     for (int i=1; i<=n; ++i){
    //         for (int j=1; j<=i/2; ++j){
    //             dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));   //不要忘了还要和自己对比
    //         }
    //     }
    //     return dp[n];
    // }

    // 2. 最优，贪心，尽量拆成3
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int res = 1;
        while(n>4){
            res *= 3;
            n -= 3;
        }
        return res*n;
    }
}