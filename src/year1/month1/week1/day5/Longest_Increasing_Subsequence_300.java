package year1.month1.week1.day5;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_300 {
}
class Solution_300 {
    //dp[i]表示末尾为nums[i]的最长子序列的长度
    //第一个for循环遍历所有元素
    //第二个for循环遍历i之前的递增序列看看能不能加上nums[i]
    //在第一个for循环里面比较出最大值

    //dp[i]=Math.max( dp[i], dp[j]+1 )
    //所有dp最少是1
    //max初始化是1
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max=1;
        Arrays.fill(dp, 1);
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[j]<nums[i])dp[i]=Math.max( dp[i], dp[j]+1 );
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}