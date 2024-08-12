package year1.month1.week1.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Full_Arrangement_II_47 {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        traversal(nums,used);
        return result;
    }

    private void traversal(int[] nums, boolean[] used) {
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i]) || used[i])continue;

            set.add(nums[i]);
            used[i]=true;
            path.add(nums[i]);
            traversal(nums,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}