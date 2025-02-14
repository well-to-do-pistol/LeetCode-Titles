package titles.sliding_window;

import java.util.*;

public class Find_All_Letter_Synonyms_In_The_String_438 {
}
class Solution_438 {
    // 1. 用int[26]来记录字符映射, 直接用Arrays.equals()来比较数组
    // 普通的滑窗, 先算前pLen, 再从i=0开始, 每次从映射删去i位置字符, 添加i+pLen, 如果相同则结果数组添加i+1
    public List<Integer> findAnagrams(String s, String p) {
        int pLen=p.length(), sLen=s.length();
        List<Integer> res = new ArrayList<>();
        if(sLen<pLen)return res;

        int[] sC = new int[26];
        int[] pC = new int[26];
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        for(int i=0; i<pLen; ++i){
            ++sC[sChars[i]-'a'];
            ++pC[pChars[i]-'a'];
        }
        if(Arrays.equals(sC,pC))res.add(0);
        for(int i=0; i<sLen-pLen; ++i){
            --sC[sChars[i]-'a'];
            ++sC[sChars[i+pLen]-'a'];
            if(Arrays.equals(sC,pC))res.add(i+1);
        }
        return res;
    }


    // 2. 自己想的终极暴力解法
    // public List<Integer> findAnagrams(String s, String p) {
    //     char[] cs = p.toCharArray();
    //     Arrays.sort(cs);
    //     String key = new String(cs);

    //     char[] chars=s.toCharArray();
    //     int pLen=p.length();
    //     int n=s.length()-pLen;
    //     List<Integer> res = new ArrayList<>();
    //     for(int i=0; i<=n; ++i){
    //         char[] tmp = new char[pLen];
    //         for(int j=i; j<i+pLen; ++j){
    //             tmp[j-i]=chars[j];
    //         }
    //         Arrays.sort(tmp);
    //         if(new String(tmp).equals(key)){
    //             res.add(i);
    //         }
    //     }
    //     return res;
    // }
}