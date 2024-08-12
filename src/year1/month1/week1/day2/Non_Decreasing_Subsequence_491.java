package year1.month1.week1.day2;

import java.util.*;

public class Non_Decreasing_Subsequence_491 {
}

class Solution11 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        traversal(nums,0);
        return result;
    }

    private void traversal(int[] nums, int index) {
        if (path.size()>1)result.add(new ArrayList<>(path));

        HashSet<Integer> used = new HashSet<>();
        for (int i=index; i<nums.length; i++){
            if (!path.isEmpty() && path.get(path.size()-1)>nums[i] || used.contains(nums[i])){
                continue;
            }//去重逻辑
            used.add(nums[i]);
            path.add(nums[i]);
            traversal(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}