package year1.month1.week1.day5;

public class Different_Subsequences_115 {
}
class Solution_115 {

    //bagg
    //bag
    //dp[i][j]表示以chars1[i-1]和chars[j-1]结尾的个数，初始化方便
    //相同时, dp[i-1][j-1]+dp[i-1][j] 因为是看s有多少个能组成t,所以i-1
    //bag和ba是1，bag和bag也是1，加起来等于2
    //不相同时，dp[i-1][j]
    //bag和ba不相等就等于ba和ba等于1

    //dp[0][j]空的组成t->0
    //dp[i][0]s组成空的->1
    //dp[0][0]->1
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];
        char[] chars1= s.toCharArray();
        char[] chars2= t.toCharArray();
        for (int i=0; i<=len1; i++)dp[i][0]=1;

        for (int i=1; i<=len1; i++){
            for (int j=1; j<=len2; j++){
                if (chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}