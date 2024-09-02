package year1.month1.week2.day1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class The_Longest_Substring_Without_Duplicate_Characters_3 {
    public static void main(String[] args) {
        Solution_3 solution3 = new Solution_3();
        solution3.lengthOfLongestSubstring("abcbcabcc");
    }
}
class Solution_3 {
    //用左右指针记录滑动窗口的左右边界
    //一个一个加,如果存在就删去头部(left)(循环删,因为不一定是头部重复,一直到删除重复的元素)
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int left=0;
        int right=0;
        char[] chars=s.toCharArray();
        Set<Character> stack=new HashSet<>();
        while (right<s.length()){
            right++;
            while (stack.contains(chars[right-1])){
                stack.remove(chars[left]);
                left++;
            }
            stack.add(chars[right-1]);
            max=Math.max(max,right-left);
        }
        return max;
    }
}