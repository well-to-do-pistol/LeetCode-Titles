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
    // 递推公式基于第二层循环的dp[j]，即我们认为dp[j]已经计算出来，只需要将nums[j]与nums[i]对比即可算出dp[i]=dp[j]+1
    // dp[i]为考虑到i索引数字的最长递增子序列
    // 两层for循环，第一层遍历i，第二层遍历i之间的数j
    // 如果j<i，那么就可以用dp[j]+1来得到dp[i]，即
    // dp[i] = Math.max(dp[i],dp[j]+1)
    // dp所有初始化为1，每轮第二层循环完后，用dp[i]的值更新最大值，因为结果可能出现在任何为i结尾的序列
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i=1; i<nums.length; ++i){
            for (int j=0; j<i; j++){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}