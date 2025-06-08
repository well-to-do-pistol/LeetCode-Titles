package titles.two_pointers;

public class Num_Subarray_Product_Less_Than_K_713 {
}
class Solution_713 {
    // 双指针法，都从最左边开始
    // for（for移动r）里加while，不符合则删左边
    // 最后如果符合，就加上r-l+1
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        long product = 1;
        int res = 0;
        for (;r<n;++r){
            product*=nums[r];
            while(l<=r && product>=k){
                product/=nums[l++];
            }
            if (l<=r)
                res += r-l+1;
        }
        return res;
    }
}