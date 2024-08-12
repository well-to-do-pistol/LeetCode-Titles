package year1.month1.week1.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII_90 {
}
class Solution {
    //和组合II的问题一样，要去重
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        traversal(nums,0,used);
        return result;
    }

    private void traversal(int[] nums, int index, boolean[] used) {
        result.add(new ArrayList<>(path));//每一个节点都要加
        if (index>=nums.length)return;

        for (int i=index; i<nums.length; i++){
            if (i>=1 && nums[i]==nums[i-1] && !used[i - 1])continue; //去重

            used[i]=true;
            path.add(nums[i]);
            traversal(nums,i+1,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}