package titles.dynamic_programming.multidimensional_dynamic_programming.edit_distance;

public class Longest_Common_Subsequence_1143 {
}



class Solution_1143 {
    // dp[i][j]考虑chars1[i-1]和chars2[j-1]的最长公共子序列,s1从i开始,s2从j开始遍历；因为dp[i][j]代表i-1和j-1所以首行和首列不用初始化
    // dp[i][j]:如果chars1[i-1]==chars2[j-1]，为dp[i-1][j-1]+1
    // 不等的话，max(dp[i-1][j],dp[i][j-1])
    // abc                              abc          ab
    // ace  c不等于e，那么最长有可能是    ac    和     ace
    // 遍历循序正常，因为dp[i][j]依赖之间的值
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[l1+1][l2+1];
        for (int i=1; i<=l1; ++i){
            for (int j=1; j<=l2; ++j){
                if (chars1[i-1]==chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }
}