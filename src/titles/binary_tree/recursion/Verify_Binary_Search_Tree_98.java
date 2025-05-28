package titles.binary_tree.recursion;

import java.util.*;

public class Verify_Binary_Search_Tree_98 {
}

class Solution_98 {

    // 最快, 用两个变量记录最大值和最小值, 利用左右子树的特点进行递归传递
    // 左右子树必须是二叉搜索树, 而且当前节点要大于最小值, 小于最大值
    public boolean isValidBST(TreeNode root) {
        return recursion(root, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    private boolean recursion(TreeNode root, double min, double max){
        if(root==null) return true;
        if((root.val <= min) || (root.val >= max)) return false;
        return recursion(root.left, min, root.val) && recursion(root.right, root.val, max);
    }

    // 中序遍历(迭代), 然后判断是否大于前一个, 使用double最小值(必须要用-Double.MAX_VALUE)为第一个pre
    // public boolean isValidBST(TreeNode root) {
    //     Stack<TreeNode> stack = new Stack<>();
    //     double pre = -Double.MAX_VALUE;
    //     while(!stack.isEmpty() || root!=null){
    //         while(root!=null){
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         root = stack.pop();
    //         if(pre>=root.val)return false;
    //         pre = root.val;
    //         root = root.right;
    //     }
    //     return true;
    // }
}
