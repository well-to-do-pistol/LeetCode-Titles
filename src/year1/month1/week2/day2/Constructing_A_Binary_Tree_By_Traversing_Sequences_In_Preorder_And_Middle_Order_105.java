package year1.month1.week2.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Constructing_A_Binary_Tree_By_Traversing_Sequences_In_Preorder_And_Middle_Order_105 {
}

class Solution_105 {
    //中序值和索引加到map
    //拿前序第一个为根
    //从map拿到索引
    //索引-inBegin=左数组长度
    //左子树, 切中序, 前序
    //右子树, 切中序, 前序
    //左闭右闭
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        for (int i=0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = traversal(inorder,0,inorder.length,preorder,0,preorder.length);
        return root;
    }

    private TreeNode traversal(int[] inorder, int inBegin, int inEnd, int[] preorder, int preBegin, int preEnd) {
        if (preBegin>=preEnd || inBegin>=inEnd)return null;
        TreeNode root=new TreeNode(preorder[preBegin]);
        int index=map.get(preorder[preBegin]);
        int leftLen=index-inBegin;
        root.left=traversal(inorder,inBegin,index,preorder,preBegin+1,preBegin+1+leftLen);
        root.right=traversal(inorder,index+1,inEnd,preorder,preBegin+1+leftLen,preEnd);
        return root;
    }
}