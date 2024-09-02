package year1.month1.week2.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pre_Order_Traversal_Of_Binary_Trees_144 {

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

class Solution_144 {
    //前序遍历:中左右, 用栈来模拟递归, 中右左
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null)return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if (cur.right!=null)stack.push(cur.right);
            if (cur.left!=null)stack.push(cur.left);
        }
        return res;
    }
}