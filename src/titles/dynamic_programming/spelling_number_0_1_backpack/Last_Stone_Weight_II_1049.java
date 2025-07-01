package titles.dynamic_programming.spelling_number_0_1_backpack;

public class Last_Stone_Weight_II_1049 {
}
class Solution_1049 {
    // 算总和/2，看成背包问题，尽可能拼成1半，然后结果为sum-2*dp[sum/2]
    // dp[j]容量为j的最大价值
    // dp[j]=max(dp[j],dp[j-nums[i]]+nums[i])
    // 先物品后背包，背包倒序
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num:stones)
            sum+=num;
        int half = sum/2;
        int[] dp = new int[half+1];
        for (int num:stones){
            for (int j=half; j>=num; --j){
                dp[j]=Math.max(dp[j],dp[j-num]+num);
            }
        }
        return sum-2*dp[half];
    }
}