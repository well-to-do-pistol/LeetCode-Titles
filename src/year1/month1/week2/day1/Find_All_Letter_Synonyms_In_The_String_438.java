package year1.month1.week2.day1;

import java.util.*;

public class Find_All_Letter_Synonyms_In_The_String_438 {
}
class Solution_438 {
    //用26长度的数组来比较是否异位
    //先比较pLen长度的字母,如果异位加索引0. 为什么先比较?因为要删去当前i来比较数组
    //添加i+pLen的字母计数. 为什么? 因为前pLen已经添加
    //当前i为滑窗的删除, i+pLen为滑窗的添加
    //如果数组相同, 则添加i+1到结果

    //时间复杂度m+(n-m)*Z(Z为比较数组时间)
    public List<Integer> findAnagrams(String s, String p) {
        int sLen=s.length(), pLen=p.length();
        List<Integer> res=new ArrayList<>();

        if (sLen<pLen)return res;//先判断边界

        int[] sCount=new int[26];
        int[] pCount=new int[26];
        for (int i=0; i<pLen; i++){ //先比较前pLen
            ++sCount[s.charAt(i)-'a'];
            ++pCount[p.charAt(i)-'a'];
        }
        if (Arrays.equals(sCount, pCount))res.add(0);

        for (int i=0; i<sLen-pLen; i++){ //遍历到长度差就行了(不然超界)
            --sCount[s.charAt(i)-'a']; //当前i是删除
            ++sCount[s.charAt(i+pLen)-'a']; //i+pLen是添加, 因为已经添加前pLen

            if (Arrays.equals(sCount,pCount))res.add(i+1); //相同的话add i+1
        }
        return res;
    }
}