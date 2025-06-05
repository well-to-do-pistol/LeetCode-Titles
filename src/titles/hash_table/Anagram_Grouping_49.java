package titles.hash_table;

import java.util.*;

public class Anagram_Grouping_49 {
}
class Solution_49 {
    // 1. 排序(字符数组)作为键
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }


    // 2. 计数(数组记录字符次数)作为键
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     HashMap<String,List<String>> map = new HashMap<>();
    //     for(String str : strs){
    //         int[] counts = new int[26];
    //         int len = str.length();
    //         for(int i=0; i<len; ++i){
    //             ++counts[str.charAt(i)-'a'];
    //         }
    //         StringBuffer sb = new StringBuffer();
    //         for(int i=0; i<26; ++i){
    //             if(counts[i]!=0){
    //                 sb.append((char)('a'+i));
    //                 sb.append(counts[i]);
    //             }
    //         }
    //         String key = new String(sb);
    //         List<String> list = map.getOrDefault(key, new ArrayList<>());
    //         list.add(str);
    //         map.put(key,list);
    //     }
    //     return new ArrayList<>(map.values());
    // }
}