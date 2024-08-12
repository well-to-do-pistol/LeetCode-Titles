package year1.month1.week1.day4;

public class The_Best_Time_To_Buy_And_Sell_Stocks_Includes_Transaction_Fees_714 {
}

class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0]=-prices[0];
        for (int i=1; i<prices.length; i++){
            dp[i][0] = Math.max( dp[i-1][0], dp[i-1][1]-prices[i] );
            dp[i][1] = Math.max( dp[i-1][1], dp[i-1][0]+prices[i]-fee );
        }
        return dp[prices.length-1][1];
    }
}
