package titles.dynamic_programming.multidimensional_dynamic_programming.palindrome;

public class Longest_Mountain_845 {
}
class Solution_845 {  // 虽然是双指针，但还是跟回文放一块，因为解法类似
    // 遍历1到n-2，以这些点为中点
    // 用while向左或向右延伸
    public int longestMountain(int[] arr) {
        int n = arr.length, max=0;
        for (int i=1; i<n-1; ++i) {
            if (arr[i]>arr[i-1] && arr[i]>arr[i+1]) {
                int l=i-1, r=i+1;
                while (l-1>=0 && arr[l-1]<arr[l])--l;
                while (r+1<n && arr[r]>arr[r+1])++r;
                max = Math.max(max,r-l+1);
                i = r;   // 直接跳到山尾，后面会++
            }
        }
        return max;
    }
}

