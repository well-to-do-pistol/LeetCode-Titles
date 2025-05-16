package titles.dynamic_programming.coin_exchange;
import java.util.*;
public class Coin_Exchange_322 {
    
}

class Solution_322 {
    // 最少硬币数，dp[amount]就是答案, 从dp[0]->dp[1]开始计算
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);  // 不能最大值，因为最大值+1会变负数就会成结果，amount+1所在位置的数是要被计算的
        dp[0] = 0;
        for (int coin : coins) {
            for (int j=coin; j<=amount; ++j){
                if (dp[j-coin]>=0){
                    dp[j] = Math.min(dp[j-coin]+1,dp[j]);
                }
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }
}

