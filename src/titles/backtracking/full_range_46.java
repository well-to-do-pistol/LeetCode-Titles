package titles.backtracking;

import java.util.*;

public class full_range_46 {
    
}


class Solution_46 {

    // 1. 直接用标记数组就行了
    List<List<Integer>> res;
    List<Integer> buf;
    boolean[] visit;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        buf = new ArrayList<>();
        visit = new boolean[nums.length];
        backTracking(0,nums);
        return res;
    }

    private void backTracking(int i, int[] nums) {
        if (buf.size()==nums.length) {
            res.add(new ArrayList<>(buf));
            return;
        }

        for (int j=0; j<nums.length; ++j) {
            if (visit[j])
                continue;
            buf.add(nums[j]);
            visit[j] = true;
            backTracking(j+1,nums);
            visit[j] = false;
            buf.remove(buf.size()-1);
        }
    }

    // 2. 传i+1然后Colletions.swap交换
}