package titles.dynamic_programming.raid_room;

public class Raid_Room_And_Plunder_Homes_II_213 {
}
class Solution_213 {
    // [2,3,2]：偷[2,3]和偷[3,2]取最大就行了
    public int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        else if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(rob2(nums,0,nums.length-2),rob2(nums,1,nums.length-1));
    }

    private int rob2(int[] nums, int l, int r) {
        int[] dp = new int[nums.length];
        dp[l] = nums[l];
        dp[l+1] = Math.max(nums[l],nums[l+1]);
        for (int i=l+2; i<=r; ++i) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[r];
    }
}