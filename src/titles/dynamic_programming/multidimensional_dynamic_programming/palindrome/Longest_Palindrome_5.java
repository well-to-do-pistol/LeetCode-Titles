package titles.dynamic_programming.multidimensional_dynamic_programming.palindrome;

public class Longest_Palindrome_5 {
}
class Solution_5 {
    // dp[i][j]代表i到j之间是否回文
    // 先判断chars[i][j]是否相等，再判断是否<3，大于则判断dp[i+1][j-1]
    // 先遍历L，把所有长度从小到大先赋好值，再遍历i，j=i+L-1
    // max记录最长，再用一个maxBegin，就能形成最长子串了
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len<2)
            return s;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int max = 1;
        int maxBegin = 0;
        for (int i=0; i<len; ++i)
            dp[i][i] = true;
        for (int L=2; L<=len; ++L){
            for (int i=0; i<len; ++i){
                int j = i+L-1;
                if (j>=len)
                    break;
                if (chars[i]!=chars[j]){
                    dp[i][j] = false;
                }else if (j-i<2){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] && j-i+1>max){
                    max = j-i+1;
                    maxBegin = i;
                }
            }
        }
        return s.substring(maxBegin,maxBegin+max);
    }
}