package titles.backtracking;

import java.util.*;

public class full_range_46 {
    
}


class Solution_46 {

    // 1. 标记数组法
    List<List<Integer>> res;
    List<Integer> path;
    boolean[] visit;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        path = new ArrayList<>();
        visit = new boolean[n];
        backTracking(nums);
        return res;
    }

    private void backTracking(int[] nums){
        if(path.size()==n){
            res.add(new ArrayList<>(path)); // path要重复利用，所以要new个新的
            return;
        }
        for(int i=0; i<n; ++i){
            if(visit[i])continue;
            path.add(nums[i]);
            visit[i]=true;
            backTracking(nums);
            visit[i]=false;
            path.remove(path.size()-1);
        }
    }

    // 2. 传i+1然后Colletions.swap交换
}