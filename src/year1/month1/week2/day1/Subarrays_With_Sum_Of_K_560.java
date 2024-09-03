package year1.month1.week2.day1;

import java.util.*;

public class Subarrays_With_Sum_Of_K_560 {
}
class Solution_560 {
    //用前缀+哈希表的方式来累加和
    //用pre-k判断是否存在前缀(证明pre的值等于k或pre1..pre2 -> pre2=k)
    //更新前缀会累加存在前缀的值(负数的情况)
    //pre一直累加,所以连续
    public int subarraySum(int[] nums, int k) {
        int pre=0;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0; i<nums.length; i++){
            pre+=nums[i];
            if (map.containsKey(pre-k))count+=map.get(pre-k);
            map.put(pre,map.getOrDefault(pre,0)+1); //pre的值+1
        }
        return count;
    }
}

//class Solution_560 {
//    //确定开头,然后从开头往回遍历,判断sum
//    public int subarraySum(int[] nums, int k) {
//        int count=0;
//        for (int start=0; start<nums.length; start++){
//            int sum=0;
//            for (int end=start; end>=0; end--){
//                sum+=nums[end];
//                if (sum==k)count++;
//            }
//        }
//        return count;
//    }
//}

