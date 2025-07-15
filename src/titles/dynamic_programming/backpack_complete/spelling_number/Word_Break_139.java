package titles.dynamic_programming.backpack_complete.spelling_number;
import java.util.*;
public class Word_Break_139
{
}
class Solution_139 {

    /**
     最简方法的优化，最快
     */
    // 计算最大单词长度，来决定start从max(0,j-maxLen)开始，因为start太小，substring得到的单词长度过长无意义
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String word:set){
            maxLen = Math.max(maxLen,word.length());
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int j=1; j<=s.length(); ++j){      // 注意要<=n，因为substring要n才能包含最后一个          int start = Math.max(0,maxLen);
            int start = Math.max(0,j-maxLen);
            for (int i=start; i<j; ++i){
                if (dp[i] && set.contains(s.substring(i,j))) {
                    dp[j] = true;
                    break;                      // 一旦找到一种分隔方式就退出循环
                }
            }
        }
        return dp[s.length()];
    }

    /**
     最简方法，但慢
     */
    // 完全背包问题。遍历字符串的所有单词组合，放进对应背包
    // 因为字符串的单词顺序是特定的，所以必须是排列，先背包后物品。
    // 将数组转成集合，查看单词是否在集合中
    // dp[j]代表字符串从0到j索引的字符串是否能被集合中 的单词拼成
    // dp[j] = dp[i] && isIn(i,j)

    // j从1开始，为单词尾，i从0开始，为单词头
    // 相当于整个字符串，分成无数小字符串，查看里面的单词是否对应集合里的单词
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> set = new HashSet<>(wordDict);
    //     boolean[] dp = new boolean[s.length()+1];
    //     dp[0] = true;
    //     for (int j=1; j<=s.length(); ++j){      // 注意要<=n，因为substring要n才能包含最后一个
    //         for (int i=0; i<j; ++i){
    //             if (dp[i] && set.contains(s.substring(i,j))) {
    //                 dp[j] = true;
    //                 break;                      // 一旦找到一种分隔方式就退出循环
    //             }
    //         }
    //     }
    //     return dp[s.length()];
    // }
}