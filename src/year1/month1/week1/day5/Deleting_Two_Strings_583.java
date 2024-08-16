package year1.month1.week1.day5;

public class Deleting_Two_Strings_583 {
    public static void main(String[] args) {
        Solution_583 solution583 = new Solution_583();
        solution583.minDistance("leetcode","etco");
    }
}
class Solution_583 {

    //sea
    //eat
    //dp[i][j]:以chars1[i-1]和chars2[j-1]为结尾的最少删减步数
    //相等时:dp[i-1][j-1]
    //不相等时:dp[i-1][j],dp[i][j-1]的最少值+1（因为sea和eat可能会倒过来）, 还有一种情况eat eas,两个都删就是dp[i-1][[j-1]+2

    //dp[i][0]组成空或单个：i
    //dp[0][j]组成空或单个: j
    //dp[0][0]:0
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp = new int[len1+1][len2+1];
        char[] chars1=word1.toCharArray();
        char[] chars2=word2.toCharArray();

        for (int i=0; i<=len1; i++)dp[i][0]=i;
        for (int j=0; j<=len2; j++)dp[0][j]=j;

        for (int i=1; i<=len1; i++){
            for (int j=1; j<=len2; j++){
                if (chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1]+2,Math.min(dp[i-1][j],dp[i][j-1])+1);
                }
//                System.out.print(dp[i][j]+"\t");
            }
//            System.out.println("");
        }
        return dp[len1][len2];
    }
}