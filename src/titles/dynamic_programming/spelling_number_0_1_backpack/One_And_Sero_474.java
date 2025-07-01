package titles.dynamic_programming.spelling_number_0_1_backpack;

public class One_And_Sero_474 {
}
class Solution_474 {
    // dp[i][j]i个0和j个1的最大子集个数
    // dp[i][j]=max(dp[i][j],dp[i-zero][j-one]+1);
    // 先物品后背包，背包倒序
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<strs.length; ++i){
            int zero = 0, one = 0;
            for (char c:strs[i].toCharArray()){
                if (c=='0')
                    ++zero;
                if (c=='1')
                    ++one;
            }
            for (int j=m; j>=zero; --j){
                for (int k=n; k>=one; --k){
                    dp[j][k]=Math.max(dp[j][k],dp[j-zero][k-one]+1);
                }
            }
        }
        return dp[m][n];
    }
}