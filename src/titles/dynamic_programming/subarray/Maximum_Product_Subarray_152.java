package titles.dynamic_programming.subarray;

public class Maximum_Product_Subarray_152 {
}
class Solution_152 {
    // 原本是一个max数组，一个min数组，现在直接用滚动数组，因为只和前一个状态有关
    // 用res记录遍历完每个索引的最大值max，用maxC和minC变量记录以i结尾最大和最小乘积（因为有负数必须有最小），用maxPre和minPre来暂存，因为需要更新
    public int maxProduct(int[] nums) {
        int maxC = nums[0], minC = nums[0], res = nums[0];
        for (int i=1; i<nums.length; ++i){
            int maxPre = maxC;
            int minPre = minC;
            maxC = Math.max(nums[i],Math.max(nums[i]*maxPre,nums[i]*minPre));
            minC = Math.min(nums[i],Math.min(nums[i]*maxPre,nums[i]*minPre));

            res = Math.max(res,maxC);
        }
        return res;
    }
}