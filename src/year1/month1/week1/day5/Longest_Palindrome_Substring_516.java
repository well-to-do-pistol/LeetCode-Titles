package year1.month1.week1.day5;

public class Longest_Palindrome_Substring_516 {
}
class Solution_516 {
    //和回文子串类似，但是不连续
    //dp[i][j]表示[i,j]之间的最长回文子串长度
    //chars[i]和chars[j]相同时，dp[i+1][j-1]+2
    //不相同时，dp[i+1][j],dp[i][j-1]  bba的最长为bb的长度, abb同理

    //j>i
    //j=i时，为1(这里无法包含在相同里了，因为会+2，所以必须初始化)

    //dp[i][j-1]    dp[i][j]        从下到上，从左到右
    //dp[i+1][j-1]  dp[i+1][j]

    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();

        for (int i=0; i<len; i++)dp[i][i]=1;

        for (int i=len-1; i>=0; i--){
            for (int j=i+1; j<len; j++){
                if (chars[i]==chars[j]){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}