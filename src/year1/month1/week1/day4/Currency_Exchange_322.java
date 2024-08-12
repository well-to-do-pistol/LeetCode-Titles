package year1.month1.week1.day4;

import java.util.Arrays;

public class Currency_Exchange_322 {
}
class Solution_322 {
    //dp[j]:组成j的最少硬币数
    //完全背包问题
    //不能用最大值啊
    public int coinChange(int[] coins, int amount) {
       int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0]=0;
        for (int i=0; i<coins.length; i++){
            for (int j=coins[i]; j<=amount; j++){
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}