package titles.array;

import java.util.*;

public class First_Missing_Positive_41 {
}

class Solution_41 {

    // 1. 置换:
    // 使用置换法，将1到n之间的数i放在位置i-1上
    // 用while不断进行置换，直到当前位置所有数i都放置正确nums[nums[i]-1]==nums[i]
    // 最后遍历一次，第一个i位置上不等于i+1时返回i+1
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for (int i=0; i<n; ++i) {
            while (nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i=0; i<n; ++i) {
            if (nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }


    // 2. 自己想的, 较慢, 因为需要排序时间复杂度是nlogn
    // public int firstMissingPositive(int[] nums) {
    //     int pre=1;
    //     Arrays.sort(nums);
    //     for(int x : nums){
    //         if(x<=0)continue;
    //         if(x==pre)++pre;
    //     }
    //     return pre;
    // }
}

