package year1.month1.week1.day5;

public class Non_Intersecting_Lines_1035 {
}
class Solution_1035 {
    //和1143相同
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[][] dp = new int[len1+1][len2+1]; //初始化方便

        for (int i=1; i<=len1; i++){
            for (int j=1; j<=len2; j++){
                dp[i][j] = nums1[i-1]==nums2[j-1] ? dp[i-1][j-1]+1 : Math.max( dp[i][j-1], dp[i-1][j] );
            }
        }
        return dp[len1][len2];
    }
}