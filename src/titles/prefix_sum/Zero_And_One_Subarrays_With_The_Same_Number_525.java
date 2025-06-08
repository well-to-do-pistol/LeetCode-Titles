package titles.prefix_sum;
import java.util.*;
public class Zero_And_One_Subarrays_With_The_Same_Number_525 {
}
class Solution_525 {
    // 同和为k的子数组差不多，但是这里是求最长连续，则只拿最早出现的前缀和索引来得到更长的长度，所以后面重复出现都不会put
    // 0与1个数相等，可以先把0全转为-1，然后即求和为0的子数组。即求前缀和相等的索引差
    // put(0,-1)因为要保留从索引0开始的情况，-1就相当于有个索引为-1的0数
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);
        int sum = 0;
        int max = 0;
        for (int i=0; i<nums.length; ++i){
            sum += nums[i]==0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)){
                max = Math.max(max,i-sumToIndex.get(sum));
            } else{
                sumToIndex.put(sum,i);
            }
        }
        return max;
    }
}