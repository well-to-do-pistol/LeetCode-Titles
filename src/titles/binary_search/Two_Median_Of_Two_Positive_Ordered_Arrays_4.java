package titles.binary_search;

public class Two_Median_Of_Two_Positive_Ordered_Arrays_4 {
}
class Solution_4 {
    // 如果长度为偶，找第n/2和n/2+1小的数，加起来/2.0
    // 如果为奇，找第n/2+1小的数
    // 写找第k小的函数
    // 就是不断比较A[k/2-1]和B[k/2-1]，如果小于等于，移除A[index]到A[k/2-1]，更新k(减去移除的数)；大于就移除B的
    // 一直到k减到1或A和B的索引超界为止
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len%2 == 0){
            return (findK(nums1,nums2,len/2)+findK(nums1,nums2,len/2+1))/2.0;
        }else{
            return findK(nums1,nums2,len/2+1);
        }
    }

    private int findK(int[] nums1, int[] nums2, int k){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while(true){
            if (index1>=n1){
                return nums2[index2+k-1];
            }
            if (index2>=n2){
                return nums1[index1+k-1];
            }
            if (k==1){        // 目的就是要k为1为止
                return Math.min(nums1[index1],nums2[index2]);
            }

            // 比较A[k/2-1]和B[k/2-1]
            int half = k/2;
            int newIndex1 = Math.min(n1-1,index1+half-1);       // 要用新索引和长度-1的最小值
            int newIndex2 = Math.min(n2-1,index2+half-1);

            if (nums1[newIndex1]<=nums2[newIndex2]){
                k-=(newIndex1-index1+1);    // 消除数的个数
                index1 = newIndex1+1;
            }else{
                k-=(newIndex2-index2+1);
                index2 = newIndex2+1;
            }
        }
    }
}