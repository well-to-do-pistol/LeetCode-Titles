package titles.two_pointers.normal;

public class Is_Palindrome_125 {
}
class Solution_125 {
    // 可以直接<='A'、'a'、'0'、'9'
    public boolean isPalindrome(String s) {
        int r = s.length()-1, l=0;
        char[] chars = s.toCharArray();
        while (l<r) {
            while (l<r && !Character.isLetterOrDigit(chars[l]))++l;
            while (l<r && !Character.isLetterOrDigit(chars[r]))--r;
            if (l<r && Character.toLowerCase(chars[l])!=Character.toLowerCase(chars[r]))
                return false;
            ++l;
            --r;
        }
        return true;
    }
}