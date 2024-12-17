package titles.a7_binary_tree;
import java.util.*;

public class Lantern_Decoration_Record_I_lcr149 {
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
//层序遍历, 用队列
// class Solution {
//     public int[] decorateRecord(TreeNode root) {
//         if(root==null)return new int[0];
//         List<Integer> list = new ArrayList<>();
//         Deque<TreeNode> stack = new ArrayDeque<>();
//         stack.add(root);
//         int size,i=0;
//         TreeNode temp;
//         while(!stack.isEmpty()){
//             size=stack.size();
//             while(size-->0){
//                 temp=stack.poll();
//                 list.add(temp.val);
//                 if(temp.left!=null)stack.add(temp.left);
//                 if(temp.right!=null)stack.add(temp.right);
//             }
//         }
//         int[] res=new int[list.size()];
//         for(int num:list){
//             res[i++]=num;
//         }
//         return res;
//     }
// }

//(固定数组)层序遍历, 用队列
class Solutionlcr149 {
    public int[] decorateRecord(TreeNode root) {
        if(root==null)return new int[0];
        int[] res = new int[1200];
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        int size,i=0;
        TreeNode temp;
        while(!stack.isEmpty()){
            size=stack.size();
            while(size-->0){
                temp=stack.poll();
                res[i++]=temp.val;
                if(temp.left!=null)stack.add(temp.left);
                if(temp.right!=null)stack.add(temp.right);
            }
        }
        return Arrays.copyOf(res,i);
    }
}