package year1.month1.week2.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_Of_Three_Numbers_15 {
}
class Solution_15 {
    //三层for降成两层, 同时遍历头和尾, 头尾相加大于-nums[i]就继续-尾
    //因为已经排序了
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int i=0; i<len; i++){
            if (i>0 && nums[i]==nums[i-1])continue;
            int target=-nums[i];
            int third=len-1;
            for (int j=i+1; j<len; j++){
                if (j>i+1 && nums[j]==nums[j-1])continue;
                while (j<third && nums[j]+nums[third]>target){
                    third--;
                }
                if (j==third)break;
                if (nums[j]+nums[third]==target){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[third]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}