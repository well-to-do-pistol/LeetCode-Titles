package titles.binary_tree.recursion;

import java.util.*;

public class Determining_Symmetric_Binary_Trees_lcr145 {
}
// 1. 递归, 将检查变成A树的左树和B树的右树的检查, 以及A树的右树和B树的左树的检查, 一开始判断一下传入两个子树
// class Solution {
//     public boolean checkSymmetricTree(TreeNode root) {
//          if(root==null)return true;
//          return check(root.left,root.right);
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

// 2. 迭代, 和翻转差不多: 栈和队列都可以, 先加入A的左和B的右, 再加入A的右和B的左, 一开始加入root的左右
// 每次弹出两个节点(相当于遍历所有节点, 和翻转一样逐点观察是否不对称), 然后再加入四个节点
// 这里可以加空(ArrayDeque不可以加空), 翻转不可以
class Solution_lcr145 {
    public boolean checkSymmetricTree(TreeNode root) {
        if(root==null)return true;
        return check(root.left,root.right);
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