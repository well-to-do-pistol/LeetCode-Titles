package titles.sliding_window;

public class Arrangement_Of_Strings_567 {
}
class Solution {
    // 哈希表（数组）+滑窗
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1>n2)
            return false;
        int[] map = new int[26];
        for (int i=0; i<n1; ++i){
            ++map[s1.charAt(i)-'a'];
            --map[s2.charAt(i)-'a'];
        }
        if (checkZero(map))
            return true;
        for (int i=n1; i<n2; ++i){
            --map[s2.charAt(i)-'a'];
            ++map[s2.charAt(i-n1)-'a'];
            if (checkZero(map))
                return true;
        }
        return false;
    }

    private boolean checkZero(int[] nums){
        for (int num : nums) {
            if (num!=0)
                return false;
        }
        return true;
    }
}