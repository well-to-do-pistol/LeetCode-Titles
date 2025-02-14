package titles.binary_tree.traversal_of_binary_trees;
import java.util.*;
public class In_Order_Traversal_Of_Binary_Trees_94 {
}
class Solution_94 {
    //先一路遍历左边, 无法再遍历左就输出当前, 再把当前换成右, 继续循环
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                if(tmp.right!=null)cur=tmp.right;
            }
        }
        return res;
    }
}