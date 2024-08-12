package year1.month1.week1.day4;

public class Raid_Room_And_Plunder_Homes_II_213 {
}
class Solution_213 {
    //dp[j]考虑j索引房屋所能偷到的最大价值, 就是求dp[len-1]考虑所有索引的情况
    //考虑j, dp[j-2] + nums[j]
    //不考虑j, dp[j-1]
    //dp[0]=nums[0]
    //dp[1]=Math.max(nums[0], nums[1])

    //环形问题展开成线性问题：
    //1.不选头
    //2.不选尾
    //3.头尾都不选

    //其中1和2包含3
    //所以只需要把打家劫舍I作为函数，传入两个截头或去尾的数组比较大小就可以了
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len==1)return nums[0];
        if (len==2)return Math.max(nums[0],nums[1]); //还是得考虑只有两个的情况

        return Math.max(RaidRoom(nums, 0, len-1), RaidRoom(nums, 1, len));
    }

    private int RaidRoom(int[] nums, int start, int end) {
        int[] dp = new int[end-start+2]; //怕索引对不上
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for (int i=start+2; i<end; i++){
            dp[i]=Math.max( dp[i-2]+nums[i], dp[i-1] );
        }
        return dp[end-1];
    }
}