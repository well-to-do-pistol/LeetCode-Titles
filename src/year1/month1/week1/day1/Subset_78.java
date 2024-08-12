package year1.month1.week1.day1;

import java.util.ArrayList;
import java.util.List;

public class Subset_78 {
}
class Solution9 {
    //和其他回溯的区别：其他回溯是在叶子节点添加结果，子集每一个节点都添加结果
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        traversal(nums,0);
        return result;
    }

    private void traversal(int[] nums, int index) {
        result.add(new ArrayList<>(path));
        if (index>=nums.length)return;

        for (int i=index; i<nums.length; i++){
            path.add(nums[i]);
            traversal(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}