package year1.month1.week1.day4;

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
    //后序遍历利用左右子树的数据找到当前节点的最大值
    //只有选当前节点和不选当前节点两种, 定义一个2长度数组，返回这个数组代表选和不选的最大值
    //选：dp[1]=当前值加左右子树的dp[0]
    //不选：dp[0]=左右子树的dp[0]和dp[1]中取最大值相加（因为左右子树随便怎么选）
    //       3{6,7} 答案是7
    //2{3,2}   3{1,3}
    //3{0,3}   1{0,1}
    public int rob(TreeNode root) {
        int[] dp = RobRoom(root);
        return Math.max(dp[0],dp[1]);
    }

    private int[] RobRoom(TreeNode root) {
        if (root==null)return new int[]{0,0};

        int[] leftDp = RobRoom(root.left);
        int[] rightDp = RobRoom(root.right);

        int val1 = Math.max(leftDp[0],leftDp[1]) + Math.max(rightDp[0],rightDp[1]);//不选
        int val2 = root.val + leftDp[0] + rightDp[0]; //选

        return new int[]{val1, val2};
    }
}