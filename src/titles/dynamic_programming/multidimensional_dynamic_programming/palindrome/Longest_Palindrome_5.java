package titles.dynamic_programming.multidimensional_dynamic_programming.palindrome;

public class Longest_Palindrome_5 {
}
class Solution_5 {
    // boolean[][]代表i到j是否回文
    // 当前是否回文要看i+1,j-1，方向从右上到左下
    // 如果不相等，那就是false；相等且等于2为true，否则判断i+1,j-1是否true
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i=0; i<n; ++i) {
            dp[i][i] = true;
        }
        int max=1, start=0;
        // 从每个点开始扩张，所以size应该放外面，点的起点不同i放里面
        for (int size=2; size<=n; ++size) {
            for (int i=0; i<n-1; ++i) {
                int j = i+size-1;
                if (j>=n)          // 直接后面不用遍历了
                    break;
                if (chars[i]==chars[j]) {
                    if (size==2 || dp[i+1][j-1]) {
                        dp[i][j]=true;
                        if (size>max) {
                            max = size;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
}