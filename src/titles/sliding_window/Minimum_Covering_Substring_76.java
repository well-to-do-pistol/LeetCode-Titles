package titles.sliding_window;

import java.util.*;

public class Minimum_Covering_Substring_76 {
}

class Solution_76 {

    // 1. 最优滑窗写法
    // 用count来记录匹配到数，count等于tLen就是成功
    // 然后++l
    // 不断判断当前tMap是否大于0
    // 只有sMap<tMap时才++count
    public String minWindow(String s, String t) {
        int l=0, r=0, ansL=-1, min=Integer.MAX_VALUE, sLen=s.length(), tLen=t.length(), count=0;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        char[] sMap = new char[128];
        char[] tMap = new char[128];
        for (char c:tChar)
            ++tMap[c];
        while (r<sLen) {
            if (tMap[sChar[r]]>0) {
                ++sMap[sChar[r]];
                if (sMap[sChar[r]] <= tMap[sChar[r]])
                    ++count;
                while (count==tLen) {
                    if (r-l+1<min) {
                        min=r-l+1;
                        ansL=l;
                    }
                    --sMap[sChar[l]];                                           // 左移同时不要忘了删sMap
                    if (tMap[sChar[l]]>0 && sMap[sChar[l]] < tMap[sChar[l]]) {  // 左边界左移，不能判断<=，等于证明还没删到关键的点
                        --count;
                    }
                    ++l;
                }
            }
            ++r;
        }
        return ansL==-1 ? "" : s.substring(ansL,ansL+min);
    }


    // 2. (较慢)双指针+哈希表形成滑动窗口
    // 如果每个字符的值都大于等于tMap对应的值, 则check为true, 左指针右移并将哈希表对应字符-1
    // HashMap<Character, Integer> sMap;
    // HashMap<Character, Integer> tMap;
    // public String minWindow(String s, String t) {
    //     int l=0, r=0, ansL=-1, ansR=-1, sLen=s.length(), len=Integer.MAX_VALUE;
    //     char[] sChars = s.toCharArray();
    //     char[] tChars = t.toCharArray();
    //     sMap = new HashMap<>();
    //     tMap = new HashMap<>();
    //     for(char c:tChars)
    //         tMap.put(c,tMap.getOrDefault(c,0)+1);
    //     while(r<sLen){
    //         sMap.put(sChars[r],sMap.getOrDefault(sChars[r],0)+1);
    //         while(check() && l<=r){
    //             if(r-l+1 < len){
    //                 len = r-l+1;
    //                 ansL = l;
    //                 ansR = r+1;
    //             }
    //             sMap.put(sChars[l],sMap.getOrDefault(sChars[l],0)-1); //左指针右移
    //             ++l;
    //         }
    //         ++r;
    //     }
    //     return ansL==-1 ? "" : s.substring(ansL,ansR);                //substring的s都是小写
    // }

    // private boolean check(){
    //     for(Map.Entry<Character,Integer> entry : tMap.entrySet()){
    //         char c = entry.getKey();
    //         int v = entry.getValue();
    //         if(sMap.getOrDefault(c,0)<v){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
