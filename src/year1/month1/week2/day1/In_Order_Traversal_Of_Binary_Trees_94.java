package year1.month1.week2.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class In_Order_Traversal_Of_Binary_Trees_94 {
}
class Solution_94 {
    //左中右
    //用cur来记录一直向左遍历, 直到没有才pop出来,查看pop出来的有没有右子节点,有则变为cur
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null)return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                TreeNode temp = stack.pop(); //弹出来
                res.add(temp.val);
                if (temp.right!=null)cur=temp.right;
            }
        }
        return res;
    }
}