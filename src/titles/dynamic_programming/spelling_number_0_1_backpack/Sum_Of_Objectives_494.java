package titles.dynamic_programming.spelling_number_0_1_backpack;

public class Sum_Of_Objectives_494 {
}

/**
 * 这里用了和代码随想录不一样的解法，具体可看当前git项目另一个同名类
 */
class Solution_494 {
    // sum-2*x = target，只需要求拼成x有多少种方法
    // dp[j]拼成j有多少种方法
    // dp[j]+=dp[j-nums[i]]
    // dp[0]=1
    // 先物品后背包，背包倒序
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num:nums)
            sum+=num;
        if (Math.abs(target)>sum) return 0;   // 绝对值大于sum不行
        if ((sum-target)%2!=0) return 0;      // 奇数不行
        int x = (sum-target)>>1;
        int[] dp = new int[x+1];
        dp[0] = 1;
        for (int num : nums){
            for (int j=x; j>=num; --j){
                dp[j]+=dp[j-num];
            }
        }
        return dp[x];
    }
}