package titles.binary_search;

public class Search_For_Rotate_Array_33 {
}

class Solution_33 {
    // 1.旋转数组里找最小点（二分）
    // 2.旋转数组里直接像普通数组那样找数（前提有最小点，从最小点开始）
    public int search(int[] nums, int target) {
        int n = nums.length;
        int min = 0, m, i;
        for (int l=1, r=n-1; l<=r; ){
            m = l+((r-l)>>1);
            if (nums[min]<nums[m])
                l = m+1;
            else {
                r = m-1;
                min = m;
            }
        }
        for (int l=min, r=l+n-1; l<=r; ){
            m = l+((r-l)>>1);
            i = m%n;
            if (target>nums[i])
                l = m+1;
            else if (target<nums[i]){
                r = m-1;
            }else {
                return i;
            }
        }
        return -1;
    }
}