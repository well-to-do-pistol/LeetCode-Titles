package titles.dynamic_programming.raid_room;

public class Raid_Room_And_Plunder_Homes_198 {
}
class Solution_198 {
    /**
     一维数组
     */
    // 只跟前一种状态有关，压缩成一维
    // dp[i]为到达索引i得到的最高金额
    // 由下面的公式简化：dp[i] = max(dp[i][0], dp[i][1])
    //    = max(dp[i-1][1]+nums[i], max(dp[i-1][0], dp[i-1][1]))
    // dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i])
    // 虽然都是求最大，但动态规划就是将状态传递，所以不会漏状态
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i=2; i<nums.length; ++i) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    /**
     二维数组
     */
    // dp[i][0]为到达索引i并偷i得到的最高金额，dp[i][1]为到达索引i并不偷i得到的最高金额
    // dp[i][0] = dp[i-1][1]+nums[i]，我偷了，上一次肯定没偷
    // dp[i][1] = max(dp[i-1][0],dp[i-1][1])，我没偷，上一次可能偷了也可能没偷
    // 直接一个循环
    // public int rob(int[] nums) {
    //     int[][] dp = new int[nums.length][2];
    //     dp[0][0] = nums[0];
    //     for (int i=1; i<nums.length; ++i) {
    //         dp[i][0] = dp[i-1][1]+nums[i];
    //         dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
    //     }
    //     return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    // }
}