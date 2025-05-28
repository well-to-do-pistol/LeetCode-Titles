package titles.binary_tree.recursion;

import java.util.*;

public class Diameter_of_Binary_Trees_543 {
}

class Solution_543 {

    // 分析只有根左右三个节点的情况: 不需要根和需要根?
    // 需要根则是l+r, 不需要根则是max(l,r)+1

    // 一个点贡献1
    // 要用max记录, 可能中途算到了呢?
    // recursion返回不需要根的情况就行了
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return max;
    }

    private int recursion(TreeNode root){
        if(root==null) return 0;
        int l = recursion(root.left);
        int r = recursion(root.right);
        int noRoot = Math.max(l,r)+1;
        int Root = l+r;
        max = Math.max(max,Root);
        return noRoot;
    }
}
