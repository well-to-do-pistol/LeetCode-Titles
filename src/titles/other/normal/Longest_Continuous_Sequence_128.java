package titles.other.normal;

import java.util.*;

public class Longest_Continuous_Sequence_128 {
}
class Solution_128 {
    //1. 排序
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len==0)return 0;
        Arrays.sort(nums);
        int max=1, count=1;
        for(int i=1; i<len; ++i){
            if(nums[i]==nums[i-1])continue;
            if(nums[i]==nums[i-1]+1){
                ++count;
                max=Math.max(max,count);
            }else{
                count=1;
            }
        }
        return max;
    }


    //2. 集合
    //把所有数放集合里, 遍历集合, 只取起点, 然后计数
    // public int longestConsecutive(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for(int x:nums)
    //         set.add(x);
    //     int max=0;
    //     for(int x:set){
    //         if(!set.contains(x-1)){
    //             int count=1;
    //             while(set.contains(x+1)){
    //                 ++count;
    //                 ++x;
    //             }
    //             max=Math.max(max,count);
    //         }
    //     }
    //     return max;
    // }
}