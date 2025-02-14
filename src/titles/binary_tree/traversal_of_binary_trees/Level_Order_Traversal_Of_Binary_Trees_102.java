package titles.binary_tree.traversal_of_binary_trees;
import java.util.*;
public class Level_Order_Traversal_Of_Binary_Trees_102 {
}
class Solution { //前中后需要用栈, 层序是广搜直接用队列
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if(root==null)return res;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);
    //     while(!queue.isEmpty()){
    //         int size=queue.size();
    //         List<Integer> tmp = new ArrayList<>();
    //         while(size-->0){
    //             TreeNode cur=queue.poll();
    //             if(cur.left!=null)queue.add(cur.left);
    //             if(cur.right!=null)queue.add(cur.right);
    //             tmp.add(cur.val);
    //         }
    //         res.add(tmp);
    //     }
    //     return res;
    // }

    // 递归写法:
    // 用deep记录层数
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        recursion(root, 0);
        return res;
    }
    private void recursion(TreeNode root, int deep){
        if(root==null)return;
        ++deep;
        if(res.size()<deep){
            List<Integer> tmp = new ArrayList<>();
            res.add(tmp);
        }
        res.get(deep-1).add(root.val);
        recursion(root.left,deep);
        recursion(root.right,deep);
    }
}