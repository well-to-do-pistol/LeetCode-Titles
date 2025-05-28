package titles.binary_tree.traversal_of_binary_trees;
import java.util.*;
public class In_Order_Traversal_Of_Binary_Trees_94 {
}
class Solution_94 {

    // 需要用栈, 先一直向左, 用cur记录需要向左划的点
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if(root==null)return res;
//        TreeNode cur = root;
//        Stack<TreeNode> stack = new Stack<>();
//        while(!stack.isEmpty() || cur!=null){
//            if(cur!=null){
//                while(cur!=null){
//                    stack.push(cur);
//                    cur=cur.left;
//                }
//            }else{
//                TreeNode node = stack.pop();
//                res.add(node.val);
//                if(node.right!=null)cur=node.right;
//            }
//        }
//        return res;
//    }

    // 精简写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}