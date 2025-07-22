package titles.dynamic_programming.multidimensional_dynamic_programming.edit_distance;

public class edit_distance_72 {
}
class Solution_72 {
    // dp[i][j]为考虑chars1[i-1]和chars[j-1]的最少操作数，和最长公共子序列差不多
    // 如果不相等，dp[i][j] = min(min(dp[i-1][j],dp[i][j+1])+1,dp[i-1][j-1]+1)，前两种是添加或删除，后一种是替换
    // 相等的话直接等于dp[i-1][j-1];
    // 遍历顺序按照递推公式正常
    // 因为从i-1和j-1开始首行和首列不用初始化，但是要注意空字符串的情况无论哪边是""编辑的距离都是另一边的长度
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[l1+1][l2+1];
        for (int i=1; i<=l1; ++i)
            dp[i][0] = i;
        for (int j=1; j<=l2; ++j)
            dp[0][j] = j;
        for (int i=1; i<=l1; ++i) {
            for (int j=1; j<=l2; ++j) {
                if (chars1[i-1]!=chars2[j-1]) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[l1][l2];
    }
}