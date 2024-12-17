package titles.a7_binary_tree.recursion;

import java.util.*;

public class Flip_Binary_Tree_lcr144 {
}

//递归
// class Solution {
//     public TreeNode flipTree(TreeNode root) {
//         if(root==null)return null;
//         TreeNode temp=root.left;
//         root.left=flipTree(root.right);
//         root.right=flipTree(temp);
//         return root;
//     }
// }

// 栈和队列都行(无关弹出顺序), 直接将所有节点添加(无需关注层数), 当前节点左右子节点互换
class Solution_lcr144 {
    public TreeNode flipTree(TreeNode root) {
        if(root==null)return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left!=null)queue.add(cur.left);
            if(cur.right!=null)queue.add(cur.right);
            TreeNode temp = cur.left;
            cur.left=cur.right;
            cur.right=temp;
        }
        return root;
    }
}