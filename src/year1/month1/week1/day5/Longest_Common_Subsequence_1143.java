package year1.month1.week1.day5;

public class Longest_Common_Subsequence_1143 {
}
class Solution_1143 {
    //跟重复子数组类似
    //dp[i][j]：考虑chars1[i-1]和chars2[j-1]的最长公共子序列的长度
    //相等: dp[i-1][j-1]+1
    //不相等: Math.max( dp[i-1][j], dp[i][j-1])

    //abc   不相等，可能取abc和ac之间的最长，也可能取ab和ace之间的最长
    //ace

    //abbc
    //acee
    //dp[i][j-2]=2 相等，所以+1
    //dp[i][j-1]=2 不相等，直接取最大等于前者
    //dp[i][j]=2   不相等，直接取最大等于前者

    //为什么是chars[i-1]，因为初始化方便，如果是i的话还要比较一遍看dp[i][0]和dp[0][j]是否需要赋1

    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[len1+1][len2+1];


        for (int i=1; i<=len1; i++){
            for (int j=1; j<=len2; j++){
                dp[i][j] = chars1[i-1]==chars2[j-1] ? dp[i-1][j-1]+1 : Math.max( dp[i][j-1], dp[i-1][j] );
            }
        }
        return dp[len1][len2];
    }
    //dp[i-1][j-1]  dp[i][j-1]
}   //dp[i-1][j]    dp[i][j]