package titles.binary_tree;

import java.util.*;

public class Lantern_Decoration_Record_II_lcr150 {
}
//迭代层序遍历
// class Solution {
//     public List<List<Integer>> decorateRecord(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
//         if(root==null)return list;
//         Deque<TreeNode> stack = new ArrayDeque<>();
//         stack.add(root);
//         int size,i=0;
//         TreeNode temp;
//         while(!stack.isEmpty()){
//             size=stack.size();
//             List<Integer> t = new ArrayList<>();
//             while(size-->0){
//                 temp=stack.poll();
//                 t.add(temp.val);
//                 if(temp.left!=null)stack.add(temp.left);
//                 if(temp.right!=null)stack.add(temp.right);
//             }
//             list.add(t);
//         }
//         return list;
//     }
// }

//递归层序遍历
class Solution_lcr150  {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> decorateRecord(TreeNode root) {
        traversal(root,0);
        return list;
    }
    public void traversal(TreeNode root, int level){
        if(root==null)return;

        if(level==list.size())list.add(new ArrayList<>());
        list.get(level).add(root.val);
        traversal(root.left,level+1);
        traversal(root.right,level+1);
    }
}