package titles.a7_binary_tree;

import java.util.*;

public class Lantern_Decoration_Record_III_lcr151 {

}
//层序遍历, 使用双端队列的链表作临时数组
class Solution_lcr151 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        int size,i=0;
        boolean transfer=false;
        TreeNode temp;
        while(!stack.isEmpty()){
            size=stack.size();
            LinkedList<Integer> t = new LinkedList<>();
            if(!transfer){
                while(size-->0){
                    temp=stack.poll();
                    t.addLast(temp.val);
                    if(temp.left!=null)stack.add(temp.left);
                    if(temp.right!=null)stack.add(temp.right);
                }
            }else{
                while(size-->0){
                    temp=stack.poll();
                    t.addFirst(temp.val);
                    if(temp.left!=null)stack.add(temp.left);
                    if(temp.right!=null)stack.add(temp.right);
                }
            }
            transfer=!transfer;
            list.add(t);
        }
        return list;
    }
}