package year1.month1.week1.day4;

public class The_Best_Time_To_Buy_And_Sell_Stocks_II_122 {
}

class Solution_122 {
    //贪心思路
    //7 1 5 3 6 4
    //7 1 2 5 3 4 6
    //其实5-1 + 6-3 和 2-1+5-2 + 4-3+6-4是一样的
    //也就是说只要一直取正数利润，相加无论如何都会得到取最小和最大之间的利润，因为无论最小和最大之间有什么最终都会因为卖出和买入而抵消掉
//    public int maxProfit(int[] prices) {
//        int result = 0;
//        for (int i=0; i<prices.length-1; i++){
//            if (prices[i+1]-prices[i]>0)result+=prices[i+1]-prices[i];
//        }
//        return result;
//    }

    //动态规划
    //dp[i][0]表示持有股票时的最大金钱，dp[i][1]表示不持有股票的最大金钱
    //持有：当天买或者之前已经买  Math.max( dp[i-1][1]-prices[i] , dp[i-1][0] ) 当天买的话，一定要加上前一天不持有的金钱(因为可能前一天有赚钱)
    //不持有：当天卖（前一天一定持有）或者之前已经卖 Math.max( dp[i-1][0]+prices[i] , dp[i-1][1] )
    //其实就相当于把手头的金钱加起来（正的取最大，负的也取最大）
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i=1; i<prices.length; i++){
            dp[i][0] = Math.max( dp[i-1][1]-prices[i] , dp[i-1][0] );
            dp[i][1] = Math.max( dp[i-1][0]+prices[i] , dp[i-1][1] );
        }
        return dp[prices.length-1][1]; //最后肯定不持有股票为最大
    }
}
