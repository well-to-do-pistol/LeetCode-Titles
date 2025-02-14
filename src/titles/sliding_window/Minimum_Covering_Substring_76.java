package titles.sliding_window;

import java.util.*;

public class Minimum_Covering_Substring_76 {
}

class Solution_76 {

    // 1. 双指针+数组形成滑动窗口
    // 不是tMap里存在的字符直接跳过, 用count与tLen比较来判断是否包含了所有字符, 如果该字符的值小于等于tMap, 则++count
    // 移动左指针的时候, 如果移去的是关键字符(在tMap里存在且sMap的值小于了tMap)则count-1
    // 只有遇到关键元素(在tMap存在, 且在sMap加上或减去使得满足或不满足tMap所需值)才更新count
    public String minWindow(String s, String t) {
        int l=0, r=0, ansL=-1, ansR=-1, sLen=s.length(), tLen=t.length(), len=Integer.MAX_VALUE, count=0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] sMap = new int[128];
        int[] tMap = new int[128];
        for(char c:tChars)
            ++tMap[c];
        while(r<sLen){
            if(tMap[sChars[r]]>0){
                ++sMap[sChars[r]];
                if(sMap[sChars[r]]<=tMap[sChars[r]])
                    ++count;
                while(count==tLen){                                           //这里不用判断l<=r了, 因为count既然有长度, l就<=r
                    if(r-l+1 < len){
                        len = r-l+1;
                        ansL = l;
                        ansR = r+1;
                    }
                    --sMap[sChars[l]];
                    if(tMap[sChars[l]]>0 && sMap[sChars[l]]<tMap[sChars[l]]){ //别忘了判断左指针的字符是否在tMap里
                        --count;
                    }
                    ++l;
                }
            }
            ++r;
        }
        return ansL==-1 ? "" : s.substring(ansL,ansR);                //substring的s都是小写
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
