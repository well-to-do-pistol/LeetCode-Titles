package year1.month1.week1.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class String_Concatenation_C {
}
class Solution_scc{
    //先拿遍历所有字符串进行比较
    //相同只相差1的放进哈希表里
    //对哈希表进行dfs遍历, 将完整路径放进结果数组
    //找出结果数组元素最短的长度
    HashMap<String, List<String>> grid = new HashMap<>();
    public int stringConcate(String beginStr, String endStr, List<String> wordList){
        //全部加数组
        wordList.add(beginStr);
        wordList.add(endStr);
        int len = wordList.size();
        int size = beginStr.length();
        for (String word1 : wordList){
            grid.put(word1, new ArrayList<>());
            for (String word2 : wordList){
                if (word1.equals(word2)){
                    if (compareM(word1,word2)==size-1){
                        grid.get(word1).add(word2);
                    }
                }
            }
        }

    }

    private int compareM(String word1, String word2) {
        //dp[i][j]表示以chars1[i]-1和chars2[j-1]结尾的最长公共子串, 一开始不用比较来初始化
        //相同: dp[i-1][j-1]+1
        //不相同: dp[i-1][j-1]
        return 0;
    }
}
