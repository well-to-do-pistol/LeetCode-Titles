package titles.binary_tree.traversal_of_binary_trees;

import java.util.*;
public class Post_Order_Traversal_Of_Binary_Trees_145 {
}
class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> rev = new Stack<>(); //用栈反转比数组反转更快
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            rev.push(cur.val);
            if(cur.left!=null)stack.add(cur.left);
            if(cur.right!=null)stack.add(cur.right);
        }
        while(!rev.isEmpty()){
            res.add(rev.pop());
        }
        return res;
    }
}