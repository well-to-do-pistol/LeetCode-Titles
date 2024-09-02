package year1.month1.week2.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Post_Order_Traversal_Of_Binary_Trees_145 {
}

class Solution_145 {
    //前序遍历中左右->栈方向中右左
    //栈方向中左右->会得到中右左,翻转得到左右中就是后序遍历(用栈翻转)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null)return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> reverse = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            reverse.add(cur.val);
            if (cur.left!=null)stack.push(cur.left);
            if (cur.right!=null)stack.push(cur.right);
        }
        while (!reverse.isEmpty())res.add(reverse.pop());
        return res;
    }
}