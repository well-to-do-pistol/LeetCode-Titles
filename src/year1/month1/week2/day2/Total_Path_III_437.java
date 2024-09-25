package year1.month1.week2.day2;

import java.util.HashMap;
import java.util.Map;

public class Total_Path_III_437 {
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
    ///用map记录前缀和
    //先序遍历和深度遍历
    //前缀和+1
    //遍历完当前节点记得前缀和-1
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        int res = dfs(root,map,0L,targetSum);
        return res;
    }

    private int dfs(TreeNode root, HashMap<Long, Integer> map, Long cur, int targetSum) {
        if (root==null)return 0;
        cur+=root.val;
        int res=map.getOrDefault(cur-targetSum,0); //当前节点符合target的路径总和
        map.put(cur,map.getOrDefault(cur,0)+1);         //前缀和+1
        res += dfs(root.left,map,cur,targetSum); //深度遍历
        res += dfs(root.right,map,cur,targetSum);
        map.put(cur,map.getOrDefault(cur,0)-1); //前缀和-1, 遍历完当前节点, 防止影响其他路径
        return res;
    }
}





//class Solution_437 {
//    //以每个节点为根开始
//    //左右两个节点符合总和的数目相加
//    //如果当前节点val等于targetSum,数目加1
//    public int pathSum(TreeNode root, long targetSum) {
//        if (root == null) {
//            return 0;
//        }
//        int res = targetSum(root,targetSum);
//        res += pathSum(root.left,targetSum);
//        res += pathSum(root.right, targetSum);
//        return res;
//    }
//
//    private int targetSum(TreeNode root, long targetSum) {
//        if (root==null)return 0;
//        int res=0;
//        if (root.val==targetSum)res++;
//        res += targetSum(root.left,targetSum-root.val);
//        res += targetSum(root.right, targetSum-root.val);
//        return res;
//    }
//}





