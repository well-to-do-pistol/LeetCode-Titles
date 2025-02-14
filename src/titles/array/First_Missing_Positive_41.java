package titles.array;

import java.util.*;

public class First_Missing_Positive_41 {
}

class Solution_41 {

    // 1. 置换:
    // 将所有数拼成1到N数组, 哪个位置不为i+1, 就输出i+1 (3,4,-1,1 拼成 1,-1,3,4输出2)
    // 遍历一遍, 如果当前数x属于[1,N], 那么它和nums[x-1]交换, 一直交换知道x不属于[1,N]
    // 有可能x和nums[x-1]相等会导致无限循环, 直接跳过
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; ++i){
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i]=tmp;
            }
        }
        for(int i=0; i<n; ++i){
            if(nums[i]!=i+1){
                return i+1;
            }
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

