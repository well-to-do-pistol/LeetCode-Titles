package titles.backtracking;

import java.util.*;

public class subset_78 {
    
}

class Solution_78 {
    List<List<Integer>> res;
    List<Integer> path;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums,int i){
        res.add(new ArrayList<>(path));
        if (i==n)return;
        for (;i<n;++i){
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
