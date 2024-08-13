package year1.month1.week1.day5;

import java.util.Arrays;

public class Longest_Continuously_Increasing_Sequence_674 {
    public static void main(String[] args) {
        Solution_674 solution674 = new Solution_674();

    }
}
class Solution_674 {
    //与不连续相比：只需要跟前面比较就行了
    //dp[i]：以nums[i]结尾的最长连续序列长度
    //初始化数组：都是1
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max=1;
        for (int i=1; i<nums.length; i++){
            if (nums[i]>nums[i-1])dp[i]=Math.max( dp[i], dp[i-1]+1 );
            max=Math.max( max, dp[i] );
        }
        return max;
    }
}