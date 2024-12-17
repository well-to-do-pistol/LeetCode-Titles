package titles.a7_binary_tree.recursion;

public class Substructure_Determination_lcr143 {
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

//从某个节点开始同时遍历AB, 该点为满足下面注释3个条件的点
class Solution_lcr143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    //判断(从各自根节点出发)子树A和子树B是否相同, 1.B为null证明遍历完了, 可以为true; 2.A为null证明先于B遍历完了, 肯定false; 3.不相等也为false
    public boolean recur(TreeNode A, TreeNode B){
        if(B==null)return true;
        if(A==null || A.val!=B.val)return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
