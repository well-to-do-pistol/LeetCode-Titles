package year1.month1.week1.day5;

public class Edit_Distance_72 {
}
class Solution_72 {
    //dp[i][j] 表示以chars1[i-1]和chars2[j-1]为结尾的个数,方便初始化
    //相同时, dp[i-1][j-1]
    //不相同时, dp[i-1][j]+1, dp[i][j-1]+1 (sea和eat的情况); dp[i-1][j-1]+1 (eat和eal的情况)
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp = new int[len1+1][len2+1];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        for (int i=0; i<=len1; i++)dp[i][0]=i;
        for (int j=0; j<=len2; j++)dp[0][j]=j;

        for (int i=1; i<=len1; i++){
            for (int j=1; j<=len2; j++){
                if (chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j], dp[i][j-1])+1);
                }
            }
        }
        return dp[len1][len2];
    }
}