package titles.a7_binary_tree.recursion;

import java.util.*;

public class Determining_Symmetric_Binary_Trees_lcr145 {
}
//递归
// class Solution {
//     public boolean checkSymmetricTree(TreeNode root) {
//         //1. 先判断
//         // if(root==null)return true;
//         // return check(root.left,root.right);

//         //2. 直接传root
//         return check(root,root);
//     }
//     public boolean check(TreeNode A, TreeNode B){
//         if(A==null && B==null){
//             return true;
//         }else if(A!=null && B!=null){
//             return (A.val==B.val) && check(A.left,B.right) && check(A.right,B.left);
//         }else{
//             return false;
//         }
//     }
// }

//迭代
//把节点都加进队列, 前后节点一定相同(也是栈和队列都可以, 注意不要用ArrayDeque不允许空值)
class Solution_lcr145 {
    public boolean checkSymmetricTree(TreeNode root) {
        //1. 先判断
        // if(root==null)return true;
        // return check(root.left,root.right);

        //2. 直接传root
        return check(root,root);
    }
    public boolean check(TreeNode u, TreeNode v){
        Stack<TreeNode> stack = new Stack<>();

        stack.push(u);
        stack.push(v);

        while(!stack.isEmpty()){
            u = stack.pop();
            v = stack.pop();

            if(u==null && v==null){
                continue;
            }
            if(u==null || v==null || u.val!=v.val){
                return false;
            }

            stack.push(u.left);
            stack.push(v.right);
            stack.push(u.right);
            stack.push(v.left);

        }

        return true;
    }
}