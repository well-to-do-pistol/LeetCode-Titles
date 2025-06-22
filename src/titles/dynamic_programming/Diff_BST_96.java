package titles.dynamic_programming;

public class Diff_BST_96 {
}
class Solution_96 {
    // 1: 1种
    // 2: 2种
    // 3: 2种（1为头），1种（2为头），2种（3为头）
    // dp[i]i个节点多少种2叉树
    // dp[1]=1
    // dp[i]+=dp[j-1]*dp[i-j]    对于将j作为根节点，左子树节点数为j-1，右子树节点数为i-j
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2; i<=n; ++i){
            for (int j=1; j<=i; ++j){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}