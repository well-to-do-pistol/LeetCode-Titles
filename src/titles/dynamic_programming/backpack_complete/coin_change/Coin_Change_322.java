package titles.dynamic_programming.backpack_complete.coin_change;
import java.util.*;
public class Coin_Change_322 {
}

class Solution_322 {
    // 完全背包问题，零钱兑换
    // dp[j]，凑成j容量最小硬币数
    // dp[j] = min(dp[j-coins[i]]+1,dp[j])
    // 先物后容是组合，先容后物是排列，这里都行

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i=0; i<coins.length; ++i){
            for (int j=coins[i]; j<=amount; ++j){
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}