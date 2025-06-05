package titles.hash_table;

import java.util.*;

public class Sum_Of_Two_Numbers_1 {
}
class Solution_1 {
    // 无序不能用双指针，只能用map找k-num的数
    // 可以一边put一边找
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n; ++i){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}