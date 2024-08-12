package year1.month1.week1.day4;

public class The_Best_Time_To_Buy_And_Sell_Stocks_Includes_A_Freeze_Period_309 {
}
class Solution_309 {
    //持有和不持有(不持有包含冷冻期)
    //1.持有
    //2.当天卖出
    //3.冷冻期
    //4.保持不持有(非冷冻期和当天卖出)

    //dp[i][0] = Math.max( dp[i-1][0], dp[i-1][2]-prices[i]， dp[i-1][3]-prices[i] ) 前一天可能是持有或者冷冻期或者不持有（今天买）
    //dp[i][1] = dp[i-1][0]+prices[i] 前一天肯定持有
    //dp[i][2] = dp[i-1][1] 前一天肯定卖了
    //dp[i][3] = Math.max( dp[i-1][3], dp[i-1][2] ) 前一天可能是不持有或者冷冻期
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0]=-prices[0]; //其他都是0因为前面没有天数
        for (int i=1; i<prices.length; i++){
            dp[i][0] = Math.max(Math.max( dp[i-1][0], dp[i-1][2]-prices[i]), dp[i-1][3]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = dp[i-1][1];
            dp[i][3] = Math.max( dp[i-1][3], dp[i-1][2] );
        }
        return Math.max(Math.max(dp[prices.length-1][1],dp[prices.length-1][2]), dp[prices.length-1][3]);
    }//三种情况都有可能
}