package year1.month1.week1.day5;

public class Judge_Subsequences_392 {
}
class Solution_392 {
    //和找出最长公共子序列类似
    //两个for循环

    //dp[i-1][j-1]  dp[i-1]dp[j]
    //dp[i][j-1]    dp[i]dp[j]

    //dp[i][j]代表以chars1[i-1]和chars2[j-1]结尾的最长公共子序列长度,初始化不用先比较一波
    //相同，同时回退+1,dp[i-1][j-1]+1
    //不同，取dp[i-1]dp[j]和dp[i][j-1]最大值

    //abc
    //ace

    //abbc
    //acee

    //这里如果max等于s的长度，那么就是true
    //因为只会存在abce是t而ace是s的情况，所以只用dp[i][j-1]就行了
    //ac
    //abce
    //不能回退i,回退j,就能得到2
//    public boolean isSubsequence(String s, String t) {
//        int len1=s.length();
//        int len2=t.length();
//        int[][] dp = new int[len1+1][len2+1];
//        char[] chars1 = s.toCharArray();
//        char[] chars2 = t.toCharArray();
//
//        for (int i=1; i<=len1; i++){
//            for (int j=1; j<=len2; j++){
//                if (chars1[i-1]==chars2[j-1]){
//                    dp[i][j]=dp[i-1][j-1]+1;
//                }else {
////                    dp[i][j]=Math.max( dp[i-1][j], dp[i][j-1] );
//                    dp[i][j]=dp[i][j-1];
//                }
//            }
//        }
//        return dp[len1][len2]==len1;
//    }


    //简单方法，同时遍历，计算相同个数
    public boolean isSubsequence(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int index1=0;
        int index2=0;

        while (index1!=len1 && index2!=len2){
            if (s.charAt(index1)==t.charAt(index2)){
                index1++;
                index2++;
            }else {
                index2++;
            }
        }
        return index1==len1;
    }
}