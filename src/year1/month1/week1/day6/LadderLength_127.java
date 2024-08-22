package year1.month1.week1.day6;

import java.util.*;

public class LadderLength_127 {
    public static void main(String[] args) {
        Solution_127 solution127 = new Solution_127();
        int i=solution127.ladderLength("hit","cog",new ArrayList<String>(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }
}
class Solution_127{
    //广度优先遍历所有字串(要记级别)
    //将符合要求的(只有一个不同)加入queue和path
    //然后将包含终点的路径加入结果
    //遍历结果找出长度最短
    List<String> path = new ArrayList<>();
    public int ladderLength(String beginStr, String endStr, List<String> wordList){
        int len = wordList.size();
        boolean[] visited = new boolean[len];

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginStr);

        while (!queue.isEmpty()){
            String cur = queue.poll();
            path.add(cur);

            for (int i=0; i<len; i++){
                if (visited[i])continue;
                String str = wordList.get(i);
                if (compareM(cur, str)){
                    queue.add(str);
                    visited[i]=true;
                    if (str.equals(endStr)){
                        return path.size()+1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean compareM(String str1, String str2) {
        int count =0;
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i)==str2.charAt(i))count++;
        }
        return count==str1.length()-1;
    }
}