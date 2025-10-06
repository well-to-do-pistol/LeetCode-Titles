package titles.two_pointers;
import java.util.*;
public class Sum_Of_Three_Numbers_Closet_16 {
}
class Solution_16 {
    // 注意绝对值最小
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length, closest=Integer.MAX_VALUE;
        for (int i=0; i<n-2; ++i) {
            if (i>0 && nums[i]==nums[i-1])
                continue;
            int pivot = target-nums[i];
            int l = i+1, r=n-1;
            while (l<r) {
                int sum = nums[l]+nums[r];
                if (Math.abs(sum-pivot)<Math.abs(closest))
                    closest = sum-pivot;
                if (sum>pivot) {
                    --r;
                } else if (sum<pivot) {
                    ++l;
                } else {
                    return target;
                }
            }
        }
        return closest+target;
    }
}