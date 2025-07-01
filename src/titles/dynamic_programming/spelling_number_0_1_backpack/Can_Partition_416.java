package titles.dynamic_programming.spelling_number_0_1_backpack;

public class Can_Partition_416 {
}
class Solution_416 {
    // 算总和/2，然后装相应容量
    // dp[j]表示j容量的最大价值
    // dp[j]=max(dp[j],dp[j-nums[i]]+nums[i])
    // 先物品后背包，背包倒序
    // dp[j]==j ?
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum+=num;
        if ((sum&1)==1) return false;
        sum/=2;
        int[] dp = new int[sum+1];
        for (int num:nums){
            for (int j=sum; j>=num; --j){
                dp[j] = Math.max(dp[j],dp[j-num]+num);
            }
            if (dp[sum] == sum) return true;   // 提前返回
        }
        return dp[sum]==sum;
    }
}