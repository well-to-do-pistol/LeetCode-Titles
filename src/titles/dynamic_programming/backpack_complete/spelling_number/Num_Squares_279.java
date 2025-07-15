package titles.dynamic_programming.backpack_complete.spelling_number;
import java.util.*;
public class Num_Squares_279 {
}
class Solution {
    // 完全背包问题，和零钱兑换一样。就是有1,4,9之类的物品使得装满容量n的物品数最少
    // dp[j] 为装满j的最少物品数
    // dp[j] = min(dp[j],dp[j-i*i]+1)
    // 先物品后背包是组合，先背包物品是排列，这里都可以
    // 只是注意i*i相当于coins[i]就行了
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        for (int i=1; i*i<=n; ++i){
            for (int j=i*i; j<=n; ++j){
                dp[j] = Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}