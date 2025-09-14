package titles.sliding_window;

import java.util.*;

public class The_Longest_Substring_Without_Duplicate_Characters_3 {
}


class Solution_3 {

    // 2. 用128的数组，数组保存索引
    // 可以先用哈希表写
    // public int lengthOfLongestSubstring(String s) {
    //     int[] nums = new int[128];
    //     Arrays.fill(nums,-1);
    //     char[] chars = s.toCharArray();
    //     int l=0,max=0;
    //     for (int i=0; i<s.length(); ++i) {
    //         char c = chars[i];
    //         if (nums[c]>=0) {
    //             while (l<=nums[c]) {
    //                 nums[chars[l]]=0;
    //                 ++l;
    //             }
    //         }
    //         nums[c]=i;
    //         max = Math.max(max,i-l+1);
    //     }
    //     return max;
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