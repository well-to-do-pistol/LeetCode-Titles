package year1.month1.week1.day4;

public class Currency_Exchange_518 {
}

class Solution_518 {
    //完全背包问题，目标和
    //dp[j]+=dp[j-weight[i]]
    //[1,2,1] 5
    //倒序正序区别：2容量能不能用两个1（价值15），正序就是能，倒序就是只能用一个1
    //for(i=0)
    //for(j=2; j>=weight[i])
    //dp[2]=dp[1]+15=15
    //dp[1]=dp[0]+15=15
    //--------------------------------------------------------------------------------------
    //for(i=0)
    //for(j=weight[i]; j<=2)
    //dp[1]=dp[0]+15=15
    //dp[2]=dp[1]+15=30
    //--------------------------------------------------------------------------------------

    //为什么0-1背包的目标和为什么dp[j]就是组成的方法数
    //[1,1,1,1,1] 组成5
    //for(i=0)
    //for(j=4; j>=weight[i])
    //遍历到第二个1的时候，dp[1]才加等于dp[1]=2，说明组成1有两种方法了，继续遍历

    //为什么完全背包的目标和为什么dp[j]就是组成的方法数
    //for(i=0)
    //for(j=weight[i]; j<=4)
    //遍历到第一个1的时候，dp[4]一直到dp[1]都是1，因为都可以用第一个1组成
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;

        for (int i=0; i<coins.length; i++){
            for (int j=coins[i]; j<=amount; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}