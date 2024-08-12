package year1.month1.week1.day4;

import java.util.Arrays;

public class Divide_Subsets_Of_Euqual_Sums_416 {
}

class Solution_416 {
    //思路：转化成0-1背包问题
    //dp[j] = Math.max( dp[j] , dp[j-nums[i]] + nums[i] )
    //重量就是价值，如果dp[总和一半]=总和一半，就能分割
    //先遍历物品，再遍历容量，遍历容量时从后往前（确保每个物品只放一次， 而且不被前面的结果影响）
    //[1,2,3,4] dp[5] = 5
    //[1,2,3,4,5] dp[7] = 7 //但是总和为奇数不能平分
    //[2,6,10] dp[9] = 8 ; dp[10] = 10
    //不用排序，反正都会遍历到dp[6] = dp[6-1]+1 ; dp[6] = dp[6-5]+5
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i=0; i<len; i++){
            sum+=nums[i];
        }
        if (sum%2!=0)return false; //奇数a

        sum/=2; //取一半
//        Arrays.sort(nums);
        int[] dp = new int[sum+1];
        for (int i=0; i<len; i++){ //只塞一个进去，从容量小的物品遍历到容量大的物品，相当于先塞个小的（如果塞小的不够大那就会变成塞大的），都是为了求塞满价值最大
            for (int j=sum; j>=nums[i]; j--){ //dp[2]其实是15， 从小到大就会变成30
                dp[j] = Math.max( dp[j] , dp[j-nums[i]] + nums[i] );
            }

            if (dp[sum]==sum)return true; //剪枝，例如2，3遍历完加起来已经等于5了，就不用再遍历4了，时间：26ms -> 20ms
        }
        return dp[sum]==sum;
    }
}