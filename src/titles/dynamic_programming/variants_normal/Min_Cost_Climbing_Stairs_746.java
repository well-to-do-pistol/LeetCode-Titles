package titles.dynamic_programming.variants_normal;

public class Min_Cost_Climbing_Stairs_746 {
}
class Solution_746 {
    // dp[i]为到达i层所需最少花费
    // dp[0-1] = 0;
    // dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int i=2; i<=cost.length; ++i){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}