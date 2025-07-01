package titles.greedy.jumpgame;

public class Can_Jump_55 {
}
class Solution_55 {
    // i+nums[i]计算max
    // 到达后提前返回
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i=0; i<=max && i<n; ++i){
            max = Math.max(max,i+nums[i]);
            if (max>=n-1)
                return true;
        }
        return false;
    }
}