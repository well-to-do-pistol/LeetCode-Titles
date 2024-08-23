package year1.month1.week1.day6;

import java.util.*;

public class String_Concatenation_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String[] strs = scanner.nextLine().split(" ");
        List<String> wordList = new ArrayList<>();
        for (int i=0; i<n; i++){
            wordList.add(scanner.nextLine());
        }

        Solution_scc solutionScc = new Solution_scc();
        int i=solutionScc.ladderLength(strs[0],strs[1],wordList);
        System.out.println(i);
    }
}
class Solution_scc{
    //只用广度
    //用当前str, 每个位置切换26个字母, 如果在set中找到而且visited找不到, 就加入队列
    //用hashmap记录path, 第一个找到的一定是最短的
    public int ladderLength(String beginStr, String endStr, List<String> wordList){
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        map.put(beginStr, 1);
        queue.offer(beginStr);
        int len=beginStr.length();

        while (!queue.isEmpty()){
            String cur = queue.poll();
            int path = map.get(cur);
            for (int i=0; i<len; i++){
                char[] chars = cur.toCharArray();
                for (char c = 'a'; c<='z'; c++){
                    chars[i]=c;
                    String newStr=new String(chars);
                    if (newStr.equals(endStr))return path+1; //这里要换到外面来,因为end可能不在集合
                    if (set.contains(newStr) && !map.containsKey(newStr)){
//                        if (newStr.equals(endStr))return path+1;
                        queue.add(newStr);
                        map.put(newStr, path+1);
                    }
                }
            }
        }
        return 0;
    }
}
