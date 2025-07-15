package titles.dynamic_programming.subsequence;

public class Longest_Valid_Parentheses_32 {
}
class Solution_32 {
    // 只有当前i是)才计算，dp[i]是索引为i的最长子串
    // 如果i是)，i-1是(，那么dp[i] = dp[i-2]+2
    // 如果i是)，i-1是)，而且s[i-dp[i-1]-1]是(，那么dp[i] = 2+dp[i-1]+dp[i-dp[i-1]-2]
    // 因为dp[i-1]是假设i-1组成了有效子串，我们需要跳过它
    // 所有索引简单判断是否大于等于0就行了
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i=1; i<s.length(); ++i) {  // 从i=1开始
            if (chars[i]==')'){
                if (chars[i-1]=='(') {
                    dp[i] = 2 + (i-2 >=0 ? dp[i-2] : 0);
                } else if (chars[i-1]==')' && i-dp[i-1]-1>=0 && chars[i-dp[i-1]-1]=='(') {
                    dp[i] = 2 + dp[i-1] + (i-dp[i-1]-2 >=0 ? dp[i-dp[i-1]-2] : 0);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}