package titles.two_pointers;

public class Min_Sub_Array_Len_209 {
}
class Solution_209 {
    // 双指针同时从0出发
    // 用while判断是否大于等于k，若是则减去l节点，更新min
    // 判断min==Integer.MAX_VALUE返回-1
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0, n = nums.length, sum=0;
        for (int r=0; r<n; ++r){
            sum += nums[r];
            while(l<=r && sum >= target){
                min = Math.min(min,r-l+1);
                sum-=nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}