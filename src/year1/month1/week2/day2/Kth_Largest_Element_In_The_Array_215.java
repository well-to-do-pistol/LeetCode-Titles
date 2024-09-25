package year1.month1.week2.day2;

public class Kth_Largest_Element_In_The_Array_215 {
}
//class Solution_215 {
//    //Quickselect 算法
//    //Quickselect 不会像 Quicksort 那样对两个分区进行递归排序，而是仅递归到包含第 \( k \) 个最大（或最小）元素的分区。
//    //l等于r时返回nums[k]
//    //左右指针移动完后, 如果i<j则交换
//    //最后k和j比较
//    int quickselect(int[] nums, int l, int r, int k) {
//        if (l == r) return nums[k];
//        int x = nums[l], i = l - 1, j = r + 1;  //x最左, i=l-1, j=r+1
//        while (i < j) {
//            do i++; while (nums[i] < x);
//            do j--; while (nums[j] > x);
//            if (i < j){
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//            }
//        }
//        if (k <= j) return quickselect(nums, l, j, k);
//        else return quickselect(nums, j + 1, r, k);
//    }
//    public int findKthLargest(int[] _nums, int k) {
//        int n = _nums.length;
//        return quickselect(_nums, 0, n - 1, n - k);
//    }
//}


class Solution_215 {
    //堆排序只排k次, 因为每次都确定最后一个位置
    //然后拿nums[len-k]
    //从n/2-1中间开始heapify构建大根堆
    //从最后一个元素开始, 交换0(最大值), heapify(i,0), 确定最后一个元素
    //l=2*i+1,r=2*i+2,和i比较, 交换, heapify(n,largest)向下递归
    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        for (int i=n/2-1; i>=0; i--){
            heapify(_nums,n,i);
        }
        for (int i=n-1; i>=n-k; i--){
            swapM(_nums,i,0);
            heapify(_nums,i,0);
        }
        return _nums[n-k];
    }

    private void heapify(int[] nums, int n, int i) {
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if (l<n && nums[largest]<nums[l])largest=l;
        if (r<n && nums[largest]<nums[r])largest=r;
        if (largest!=i){
            swapM(nums,largest,i);
            heapify(nums,n,largest);
        }
    }

    private void swapM(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

}
