package titles.prefix_sum;

public class The_Sum_Of_The_Subarrays_On_Both_Sides_Is_Equal_724 {
}
class Solution {
    // 前缀和
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums){
            totalSum+=num;
        }
        int curSum = 0;
        for (int i=0; i<nums.length; ++i){
            curSum+=nums[i];
            if (curSum-nums[i] == totalSum-curSum){
                return i;
            }
        }
        return -1;
    }
}