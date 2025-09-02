package titles.two_pointers.binary_search;

public class Search_For_Rotate_Array_33 {
}

class Solution_33 {
    // 我们要利用模数的二分法来找target
    // 就是最小点作为左，最小点索引+n-1为右，直接二分
    // 首先找最小点，0为初
    // 三种可能：升序、倒序和最小值在中间的两边升序。这里找最小点、最后找目标都跟二分写法没有区别
    // 如果m>min，l=m+1，最小值只会在右边
    // 如果m<min，直接更新min，证明这是两边升序或倒序，右边可以不管了，直接r=m-1
    public int search(int[] nums, int target) {
        int n=nums.length, min=0 , m1,m2;
        for (int l=1,r=n-1; l<=r; ) {              // 索引要从1开始
            m1 = l+((r-l)>>1);
            if (nums[m1]>nums[min]) {
                l=m1+1;
            } else {
                min = m1;
                r = m1-1;
            }
        }
        for (int l=min,r=min+n-1; l<=r; ) {
            m1 = l+((r-l)>>1);
            m2=m1%n;
            if (nums[m2]==target) {
                return m2;
            } else if (nums[m2]>target) {
                r = m1-1;
            } else {
                l = m1+1;
            }
        }
        return -1;
    }
}