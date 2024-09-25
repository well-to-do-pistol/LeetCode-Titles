package year1.month1.week2.day2;

public class Raid_Room_And_Plunder_Homes_198 {
}
class Solution_198 {
    //不劫:dp[i-1]
    //劫:dp[i-2]+nums[i]
    public int rob(int[] nums) {
        int len=nums.length;
        if (len==1)return nums[0];
        int[] dp=new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2; i<len; i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }
}