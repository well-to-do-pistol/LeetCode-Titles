package titles.hash_table;

public class Skill_Disassembly_II_lcr169 {
}
//使用哈希表
// class Solution {
//     public char dismantlingAction(String arr) {
//         HashMap<Character,Boolean> map = new HashMap<>();
//         for(char c:arr.toCharArray()){
//             map.put(c,!map.containsKey(c));
//         }
//         for(char c:arr.toCharArray()){
//             if(map.get(c))
//                 return c;
//         }
//         return ' ';
//     }
// }

//使用有序哈希表->(适用于不限26个字母情况)
// class Solution {
//     public char dismantlingAction(String arr) {
//         HashMap<Character,Boolean> map = new LinkedHashMap<>();
//         for(char c:arr.toCharArray()){
//             map.put(c,!map.containsKey(c));
//         }
//         for(Map.Entry<Character,Boolean> e:map.entrySet()){
//             if(e.getValue())
//                 return e.getKey();
//         }
//         return ' ';
//     }
// }

//数组做哈希表, 最快, ->(适用于只限26个字母情况)
class Solution_lcr169 {
    public char dismantlingAction(String arr) {
        int[] map = new int[26];
        char[] chars = arr.toCharArray();
        for(char c:chars){
            map[c-'a']++;
        }
        for(char c:chars){
            if(map[c-'a']==1)
                return c;
        }
        return ' ';
    }
}