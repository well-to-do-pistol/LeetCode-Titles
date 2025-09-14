package titles.dynamic_programming.subsequence;
import java.util.*;
public class Length_Of_LIS_300 {
}
class Solution_300 {
    /**
     二分+贪心，更快
     */

    /**
     动态规划，较慢
     */
    // dp[i]代表以nums[i]结尾的最长递增子序列个数
    // 全部初始化为1，最后遍历取最大值
    // 大于：dp[i] = dp[i-1]+1

    // 传统遍历肯定不行，我们要先遍历以i为结尾，算出最大的dp[i]
    // 里面再加一层循环，遍历i之前的所有数j，因为i之前的dp都算出来了
    // 如果nums[j]>nums[i], dp[i] = Math.max(dp[i],dp[j]+1)
    // 在第一层里取最大max
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i=1; i<nums.length; ++i) {
            for (int j=0; j<i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}