package year1.month1.week1.day5;

public class Longest_Repeating_Subarray_718 {
}
class Solution_718 {
    //dp[i][j]:表示以nums1[i-1]和nums2[j-1]结尾的最长重复子数组的长度
    //因为如果表示nums[i]的话，不好初始化，动态数组dp[i][0]需要和dp[j][0]比较一遍看看是否需要赋值为1
    //表示nums[i-1]的话dp[i][0]就不合法了因为不能索引nums[-1]，就不用初始化直接等于0

    //dp[i][j] = dp[i-1][j-1]+1 如果相等，两个数组需要同时回退，只回退一个不符合逻辑

    //需要求所有动态数组里的值的最大值
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        int max=0;
        for (int i=1; i<=nums1.length; i++){
            for (int j=1; j<=nums2.length; j++){
                if (nums1[i-1]==nums2[j-1])dp[i][j]=dp[i-1][j-1]+1;
                if (dp[i][j]>max)max=dp[i][j];
            }
        }
        return max;
    }
}