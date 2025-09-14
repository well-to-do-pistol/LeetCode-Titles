package titles.binary_tree.recursion.total_sum_of_paths;

public class Max_Sum_Of_Paths_124 {
}
class Solution_124 {
    // 递归
    // 总是返回最大单边和(有可能两边都负，只能返回根)
    // max为全局变量
    // 直接算l和r的时候就跟0比
    // max直接加根算
    // 覆盖了：1.根; 2.根+l+r；3.根+(l/r)
    // 无论如何必须加你，反正你是负数就是0，最后将单边返回去
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findMaxPath(root);
        return max;
    }

    private int findMaxPath(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int l = Math.max(findMaxPath(root.left),0);
        int r = Math.max(findMaxPath(root.right),0);
        max = Math.max(max,l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}