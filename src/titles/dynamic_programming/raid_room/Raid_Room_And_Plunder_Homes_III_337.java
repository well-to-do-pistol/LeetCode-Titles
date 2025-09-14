package titles.dynamic_programming.raid_room;

public class Raid_Room_And_Plunder_Homes_III_337 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution_337 {
    // 每个子树保留着最大值，dp[i] = Math.max( dp[i-2]+nums[i], dp[i-1]);
    // 但是，二叉树不能像数组那样压缩，只能分两种状态返回new int[2]{}
    // dp[0]是偷，dp[1]是不偷
    public int rob(TreeNode root) {
        int[] nums = robRoom(root);
        return Math.max(nums[0],nums[1]);
    }

    private int[] robRoom(TreeNode root) {
        if (root==null) return new int[]{0,0};
        int[] lNums = robRoom(root.left);
        int[] rNums = robRoom(root.right);
        int stealNum = root.val + lNums[1] + rNums[1];
        int unstealNum = Math.max(lNums[0],lNums[1]) + Math.max(rNums[0],rNums[1]);
        return new int[]{stealNum,unstealNum};
    }
}