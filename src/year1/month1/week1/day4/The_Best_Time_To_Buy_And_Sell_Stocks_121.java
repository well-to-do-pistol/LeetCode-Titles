package year1.month1.week1.day4;

public class The_Best_Time_To_Buy_And_Sell_Stocks_121 {
    public static void main(String[] args) {
        Solution_121 solution121 = new Solution_121();
        int max = solution121.maxProfit(new int[]{7,1,5,3,6,4});
    }
}
class Solution_121 {
//    public int maxProfit(int[] prices) {
//        if (prices==null || prices.length==1)return 0;
//        int min = prices[0];
//        int profit = 0;
//        for (int i=1; i<prices.length; i++){
//            if (prices[i]-min>profit)profit=prices[i]-min;
//            min=Math.min(min,prices[i]);
//            System.out.println("profit:"+profit+"     ;      min:"+min);
//        }
//        return profit;
//    }

    //dp[i][0]表示第i天持有股票的最大金钱，dp[i][1]表示不持有股票的最大金钱
    //为什么不持有不能改为卖出？因为只表示当天卖出股票的话会少了很多状态：因为股票有可能之前就卖出了，什么都不做的状态无法表示（如果这样还要继续添加状态）
    //dp[i][0] = Math.max( dp[i-1][0] , -prices[i] )当天买或者之前已经买了
    //dp[i][1] = Math.max( dp[i-1][1] , dp[i-1][0]+prices[i] )之前已经卖了或者当前才卖(当前才卖的话那么前一天肯定持有，结果为当前加上之前的负金钱)
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0; //只有一种可能当天卖（当前买）
        for (int i=1; i<prices.length; i++){
            dp[i][0] = Math.max( dp[i-1][0] , -prices[i] ); //负数照样要最大（要成本最少）
            dp[i][1] = Math.max( dp[i-1][1] , dp[i-1][0] + prices[i] );
//            System.out.println("dp[i][0]:"+dp[i][0]+"    ;    dp[i][1]:"+dp[i][1]);
        }
        return dp[prices.length-1][1]; // 不持有一定大于持有
    }
}