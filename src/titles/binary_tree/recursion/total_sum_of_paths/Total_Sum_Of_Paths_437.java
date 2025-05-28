package titles.binary_tree.recursion.total_sum_of_paths;
import java.util.*;
public class Total_Sum_Of_Paths_437 {
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


class Solution_437 {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>(); // map肯定比list检索快
        map.put(0L,1);                               // 一定要先加前缀和0的个数为1,
        return recursion(root,map,0L,targetSum);
    }

    private int recursion(TreeNode root, HashMap<Long,Integer> map, long cur, int targetSum){
        if(root==null)return 0;
        cur+=root.val;
        int count = map.getOrDefault(cur-targetSum,0);
        map.put(cur,map.getOrDefault(cur,0)+1);
        count += recursion(root.left,map,cur,targetSum);
        count += recursion(root.right,map,cur,targetSum);
        map.put(cur,map.get(cur)-1);  // 因为这里左右子树用的是同一map,所以在左子树遍历完后,将遍历右子树,为了不影响,应当将前缀和(前缀的个数)-1
        return count;
    }

}