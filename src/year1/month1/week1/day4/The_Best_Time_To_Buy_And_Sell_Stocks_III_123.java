package year1.month1.week1.day4;

public class The_Best_Time_To_Buy_And_Sell_Stocks_III_123 {
}
class Solution_123 {
    //添加状态:第一次持有和不持有，第二次持有和不持有
    //第一次持有:dp[i][0]= Math.max( -prices[i], dp[i-1][0] ) 当天买入或之前已买入
    //第一次不持有:dp[i][1]= Math.max( dp[i-1][0]+prices[i], dp[i-1][1] ) 当天卖出（前一天肯定是第一次持有,加上）或之前已卖出
    //第二次持有:dp[i][2]= Math.max( dp[i-1][1]-prices[i], dp[i-1][2] ) 当天买入(加上第一次卖出的钱)或之前已买入
    //第二次不持有:dp[i][3]= Math.max( dp[i-1][2]+prices[i], dp[i-1][3] ) 当天卖出（前一天肯定是第二次持有,加上）或之前已卖出
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=-prices[0]; //相当于同一天第一次买入卖出又买入
        dp[0][3]=0;          //相当于同一天第一次买入卖出又买入

        for (int i=1; i<prices.length; i++){
            dp[i][0] = Math.max( -prices[i], dp[i-1][0]);
            dp[i][1] = Math.max( dp[i-1][0]+prices[i], dp[i-1][1]);
            dp[i][2] = Math.max( dp[i-1][1]-prices[i], dp[i-1][2]);
            dp[i][3] = Math.max( dp[i-1][2]+prices[i], dp[i-1][3]);
        }
        return dp[prices.length-1][3]; //为什么直接输入第二次不持有就行了？因为第二次不持有肯定包含了第一次不持有的最大值，就算第一次后面没有最大值了，第二次不持有也能得到第一次不持有的值（同一天买入卖出相当于第一次）
    }
}