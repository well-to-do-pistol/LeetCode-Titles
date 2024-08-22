package year1.month1.week1.day6;

import java.util.*;

public class String_Concatenation_C {
    public static void main(String[] args) {

    }
}
class Solution_scc{
    //广度优先遍历所有字串
    //将符合要求的(只有一个不同)加入queue和path
    //然后将包含终点的路径加入结果
    //遍历结果找出长度最短
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public int stringConcate(String beginStr, String endStr, List<String> wordList){
        Set<String> set = new HashSet<>(wordList);
        set.add(endStr);

        path.add(beginStr);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginStr);

        while (!queue.isEmpty() && !set.isEmpty()){
            String cur = queue.poll();
            for (String str : set){
                if (compareM(cur, str)){
                    path.add(str);
                    set.remove(str);//移出set
                    if (str.equals(endStr)){
                        result.add(path);
                    }
                    path.remove(str);//回溯
                }
            }
        }

        int min=Integer.MAX_VALUE;
        for (List<String> res : result){
            min=Math.min(min, res.size());
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }

    private boolean compareM(String str1, String str2) {
        int count =0;
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i)==str2.charAt(i))count++;
        }
        return count==str1.length()-1;
    }


}
