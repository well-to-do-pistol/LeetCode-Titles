package titles.divide_and_conquer;

public class Find_Kth_Largest_215 {
}
class Solution {
    // 1. QuickSelcet （两种方法差不多）
    // 随便找最左为枢纽，从l-1和r+1用do while开始，如果没交叉(i<j)则交换nums[i]和nums[j]继续
    // 这种方法使得最终j左边为小于枢纽，右边为大于枢纽
    // 判断k(就是找排序后索引为n-k的数)属于哪部分，递归
    // l==r就可以返回nums[k]了(只找枢纽)
    public int findKthLargest(int[] nums, int k) {
        return QuickSelcet(nums,0,nums.length-1,nums.length-k);
    }

    private int QuickSelcet(int[] nums, int l, int r, int k){
        int x = nums[l], i = l-1, j = r+1;
        if (l==r) return nums[k];
        while(i<j){
            do ++i; while(nums[i]<x);
            do --j; while(nums[j]>x);
            if (i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k<=j)
            return QuickSelcet(nums,l,j,k);
        else
            return QuickSelcet(nums,j+1,r,k);
    }





    // 2. 堆排序只排k次, 因为每次都确定最后一个位置
    //然后拿nums[len-k]
    //从n/2-1中间开始heapify构建大根堆
    //从最后一个元素开始, 交换0(最大值), heapify(i,0), 确定最后一个元素
    //l=2*i+1,r=2*i+2,和i比较, 交换, heapify(n,largest)向下递归
    // public int findKthLargest(int[] _nums, int k) {
    //     int n = _nums.length;
    //     for (int i=n/2-1; i>=0; i--){
    //         heapify(_nums,n,i);
    //     }
    //     for (int i=n-1; i>=n-k; i--){
    //         swapM(_nums,i,0);
    //         heapify(_nums,i,0);
    //     }
    //     return _nums[n-k];
    // }

    // private void heapify(int[] nums, int n, int i) {
    //     int largest=i;
    //     int l=2*i+1;
    //     int r=2*i+2;
    //     if (l<n && nums[largest]<nums[l])largest=l;
    //     if (r<n && nums[largest]<nums[r])largest=r;
    //     if (largest!=i){
    //         swapM(nums,largest,i);
    //         heapify(nums,n,largest);
    //     }
    // }

    // private void swapM(int[] nums, int a, int b) {
    //     int temp=nums[a];
    //     nums[a]=nums[b];
    //     nums[b]=temp;
    // }
}