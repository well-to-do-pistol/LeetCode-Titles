package year1.month1.week1.day3;

public class Different_Binary_Search_Trees_96 {
}
class Solution_96 {
    //思路：dp[i]等于所有节点作为头节点的情况相加, 而以任意节点作为头节点存在左子树所有可能*右子树所有可能
    //n=3时，dp[3]=头1+头2+头3
    //头1=dp[0]*dp[2]。  头1的情况下，左边不可能有节点，所以左子树所有可能为0个节点时的可能数，右子树所有可能为2个节点时的可能数
    //头2=dp[1]*dp[1]
    //头3=dp[2]*dp[0]
    //dp[i]+=dp[j-1]*dp[i-j], j为所有当前头节点的值, 如头1,dp[j-1]为dp[0],dp[i-j]为dp[2]
    //从小到大，把所有情况累加
    //dp[0]=1
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i=1; i<=n; i++){
            for (int j=1; j<=i; j++){ //求dp[i], 需要遍历所有头节点的情况，相加得到dp[i]
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}