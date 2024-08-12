package year1.month1.week1.day3;

public class Monitor_Binary_Tree_968 {
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

class Solution_968 {
    //思路：尽量在叶子节点的父节点添加摄像头，然后跳过2个节点，再添加摄像头
    //采用后序遍历（左右中）
    //3种状态：0.无覆盖；1.摄像头；2.有覆盖
    //4种情况：
    //1.左右孩子都是2，当前必须是无覆盖0
    //2.左右孩子至少有一个0，当前必须添加摄像头1
    //3.左右孩子至少有一个1，当前必须是有覆盖2
    //4.最后一种是最后的根节点是0状态的情况（因为遍历过来可能根节点还是无覆盖）
    //注意：如果节点是null，则默认它为有覆盖2（其他两种状态都会影响到它父节点的取值）
    int result=0;
    public int minCameraCover(TreeNode root) {
        if (traversal(root)==0)result++;
        return result;
    }

    private int traversal(TreeNode root) {
        if (root==null)return 2;
        int left = traversal(root.left);
        int right = traversal(root.right);
        if (left==2 && right==2){
            return 0;
        }
        if (left==0 || right==0){
            result++;
            return 1;
        }
        if (left==1 || right==1){
            return 2;
        }
        return -1;
    }
}