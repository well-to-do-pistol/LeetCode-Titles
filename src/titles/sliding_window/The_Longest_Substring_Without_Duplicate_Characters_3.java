package titles.sliding_window;

import java.util.*;

public class The_Longest_Substring_Without_Duplicate_Characters_3 {
}


class Solution_3 {

    // 3. 自己想的用队列+set实现滑窗
    // public int lengthOfLongestSubstring(String s) {
    //     Set<Character> set = new HashSet<>();
    //     Queue<Character> queue = new LinkedList<>();
    //     int res=0;
    //     for(char c:s.toCharArray()){
    //         if(set.contains(c)){
    //             while(!queue.isEmpty()){
    //                 char t=queue.poll();
    //                 set.remove(t);
    //                 if(t==c)break;
    //             }
    //         }
    //         set.add(c);
    //         queue.offer(c);
    //         res=Math.max(queue.size(),res);
    //     }
    //     return res;
    // }


    // 2. 双指针+set (滑窗的模板)
    // 只要set还有当前字符, 就一直弹出队列(左指针移动)
    // public int lengthOfLongestSubstring(String s) {
    //     int count=0, l=0, r=0, len=s.length();
    //     char[] chars = s.toCharArray();
    //     Set<Character> set = new HashSet<>();
    //     while(r<len){
    //         while(set.contains(chars[r])){
    //             set.remove(chars[l]);
    //             ++l;
    //         }
    //         set.add(chars[r]);
    //         ++r;
    //         count=Math.max(count,r-l);
    //     }
    //     return count;
    // }

    // 1. 双指针+数组(最快方法)
    public int lengthOfLongestSubstring(String s) {
        int count=0, l=0, r=0, len=s.length();
        char[] chars = s.toCharArray();
        int[] mInt = new int[128];
        while(r<len){
            while(mInt[chars[r]]>0){
                --mInt[chars[l]];
                ++l;
            }
            ++mInt[chars[r]];
            ++r;
            count=Math.max(count,r-l);
        }
        return count;
    }
}