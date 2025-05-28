package titles.binary_tree.recursion.total_sum_of_paths;

public class Max_Sum_Of_Paths_124 {
}
class Solution_124 {
    // 1.用max记录最终值; 2.永远只返回较大的那一边; 3.计算边的时候不要负数(跟0比得最大值)
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root==null) return 0;
        int left = Math.max(maxGain(root.left),0);
        int right = Math.max(maxGain(root.right),0);
        max = Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}