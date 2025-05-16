package titles.backtracking;
import java.util.*;
public class Combined_Total_39 {
    
}
class Solution_39 {
    // 零钱兑换是最少硬币数，统计所有情况并收集只能用回溯
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(candidates, target,candidates.length-1);
        return res;
    }

    private void backTracking(int[] candidates, int target, int i){
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (; i>=0; --i){
            int cur = candidates[i];
            target-=cur;
            if(target>=0){
                path.add(cur);
                backTracking(candidates,target,i);
                path.remove(path.size()-1);
            }
            target+=cur;
        }
    }
}