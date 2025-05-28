package titles.binary_tree.bst.avl.KthSmallest_230;

import java.util.*;

public class KthSmallest_230 {
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

 class Solution {

     // 1. 最简单的: 中序遍历迭代, 用--k找到第k小的值
     // public int kthSmallest(TreeNode root, int k) {
     //     Stack<TreeNode> stack = new Stack<>();
     //     List<Integer> res = new ArrayList<>();
     //     while(!stack.isEmpty() || root!=null){
     //         while(root!=null){
     //             stack.push(root);
     //             root=root.left;
     //         }
     //         root=stack.pop();
     //         if(--k==0)return root.val;
     //         root=root.right;
     //     }
     //     return -1;
     // }

     // 2. 如果你需要频繁地查找第k小的值，你将如何优化算法？记录当前节点的所有子树个数+1放在TreeNode属性或者map里. 通过获取当前节点的左子树的所有子树个数与k-1来比较判断去哪里获得k
     // 遍历一次计算
     // 开始获得第k小: 获取左节点个数, 与比较k-1, 等于则返回, 大于则node=left继续, 小于则node=right, k-=左节点个数+1(因为当前节点贡献1)
     public int kthSmallest(TreeNode root, int k) {
         MyBst myBst = new MyBst(root);
         return myBst.kthSmallest(k);
     }

     class MyBst{
         TreeNode root;
         HashMap<TreeNode,Integer> map;
         MyBst(TreeNode root){
             this.root = root;
             map = new HashMap<>();
             countNum(root);
         }
         private int countNum(TreeNode node){
             if(node==null)return 0;
             map.put(node, 1+countNum(node.left)+countNum(node.right));
             return map.get(node);
         }
         private int getNum(TreeNode node){
             return map.getOrDefault(node,0);
         }
         public int kthSmallest(int k) {
             TreeNode node = root;
             while(node!=null){
                 int left = getNum(node.left);
                 if(left==k-1)
                     return node.val;
                 else if(left<k-1){
                     node=node.right;
                     k-=left+1;
                 }
                 else
                     node=node.left;
             }
             return node.val;
         }
     }
 }