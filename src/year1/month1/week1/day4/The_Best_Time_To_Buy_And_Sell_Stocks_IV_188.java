package year1.month1.week1.day4;

public class The_Best_Time_To_Buy_And_Sell_Stocks_IV_188 {
    public static void main(String[] args) {
        Solution_188 solution188 = new Solution_188();
        solution188.maxProfit(2, new int[]{3,2,6,5,0,3});
    }
}
class Solution_188 {
    //用j来表示不同状态, 第i天持有或不持有的最大金钱
    //这次必须加0状态
    //dp[i][0] dp[i-1][0]
    //dp[i][1] Math.max( dp[i-1][1] , dp[i-1][0]-prices[i] )
    //dp[i][2] Math.max( dp[i-1][2] , dp[i-1][1]+prices[i] )
    //dp[i][3] Math.max( dp[i-1][3] , dp[i-1][2]-prices[i] )
    //dp[i][4] Math.max( dp[i-1][3] , dp[i-1][3]+prices[i] )

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2*k+1];
        for (int j=1; j<2*k; j+=2){
            dp[0][j]=-prices[0];
        }//初始化，都是-prices[i]，第2次之后表示买了又卖

        for (int i=1; i<prices.length; i++){
            for (int j=1; j<2*k; j+=2){ //k次，每次中有两种状态， 最后加个0状态
                dp[i][j] = Math.max( dp[i-1][j], dp[i-1][j-1]-prices[i] );  //持有
                dp[i][j+1] = Math.max( dp[i-1][j+1], dp[i-1][j]+prices[i] ); //不持有
                System.out.println("第"+i+"轮  --"+"  持有："+dp[i][j]+"   ;   不持有："+dp[i][j+1]  );
            }
        }
        return dp[prices.length-1][2*k]; //因为第k次即使没到k次也可视作同一天又买又卖相互抵消，直接输出最后一个
    }//要2*k的索引啊
}