package titles.binary_tree.build_tree;

import java.util.*;

public class Constructing_A_Binary_Tree_By_Traversing_Sequences_In_Preorder_And_Middle_Order_105 {
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

class Solution_105 {
    HashMap<Integer,Integer> ioMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = preorder.length;
        if(l==1)return new TreeNode(preorder[0]);
        ioMap = new HashMap<>();
        for(int i=0; i<l; i++){
            ioMap.put(inorder[i],i);
        }
        TreeNode root = buildT(preorder,0,l,inorder,0,l);
        return root;
    }
    private TreeNode buildT(int[] pre, int pB, int pE, int[] in, int iB, int iE){ //要两个数组同时切
        if(iB>=iE || pB>=pE)return null;
        TreeNode root = new TreeNode(pre[pB]);
        int index = ioMap.get(pre[pB]);
        int lLen = index-iB;
        root.left = buildT(pre, pB+1, pB+lLen+1, in, iB, index);
        root.right = buildT(pre, pB+lLen+1, pE, in, index+1, iE);
        return root;
    }
}