package titles.binary_tree.recursion.normal;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Lowest_Common_Ancestor_236 {
}
class Solution_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p || root==q) return root;  // 寻找pq然后返回
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;  // 直接判断left是否空,返回对侧
        if(right==null) return left;
        return root; // 两边都不为空,说明pq分列两侧,root是最终结果,肯定能返回
    }
}