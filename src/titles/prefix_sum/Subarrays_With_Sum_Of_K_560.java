package titles.prefix_sum;

import java.util.*;

public class Subarrays_With_Sum_Of_K_560 {
}

class Solution_560 {

    // 1. 前缀和+哈希表
    // 结果加上pre-k的个数, 因为只要存在pre-k, 就一定有 当前pre - 以前pre = k
    // pre为8, k为8, 结果就加上pre为0的个数
    // pre为8, k为7, 结果就加上pre为1的个数
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);             // 一定要put(0,1)
        for (int num : nums){
            sum+=num;
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }


    // 2. 枚举, 很慢
    // public int subarraySum(int[] nums, int k) {
    //     int n=nums.length, count=0;
    //     for(int i=0; i<n; ++i){
    //         int tmp=0;
    //         for(int j=i; j<n; ++j){
    //             tmp+=nums[j];
    //             if(tmp==k)++count;
    //         }
    //     }
    //     return count;
    // }
}