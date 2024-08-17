package year1.month1.week1.day5;

public class Palindrome_Substring_647 {
}
class Solution_647 {
    //dp[i][j]表示[i,j]之间的字符串是否回文
    //chars[i]和chars[j]相同时，为dp[i+1][j-1](j-i>1)（因为dp[i][i]初始化可以简化在这里(j-i=1), 而且i和j相同使用这个公式会导致i>j(j-i<1)]）
    //所以要考虑多一种情况, 判断j-i<=1直接为true

    //dp[i-1][j-1]  dp[i-1][j]
    //dp[i][j-1]    dp[i][j]  // 要求这里的dp[i][j]必须先知道dp[i+1][j-1]，从下往上，从左往右
    //dp[i+1][j-1]  dp[i+1][k]

    //aaa
    //i=2,j=i       a(2)
    //i=1,j=1,2     a(1), a(1)a(2)
    //i=0,j=0,1,2   a(0), a(0)a(1), a(0)a(1)a(2)

    //i=2,j=0,1,2
    //i=1,j=0,1,2   判断多次
    //i=0,j=0,1,2

    //i=2,j=0,1,2
    //i=1,j=0,1     a(0)a(1) a(0)a(1)  判断多次
    //i=0,j=0

    public int countSubstrings(String s) {
        int len=s.length();
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();

        int count=0;
        for (int i=len-1; i>=0; i--){
            for (int j=i; j<len; j++){ //注意从左到右，不要判断多次了，除了相等都不会重合（j必须始终大于等于i）
                if (chars[i]==chars[j]){
                    if (j-i<=1){
                        dp[i][j]=true;
                        count++;
                    }else if (dp[i+1][j-1]){  //j-i>1
                        dp[i][j]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}