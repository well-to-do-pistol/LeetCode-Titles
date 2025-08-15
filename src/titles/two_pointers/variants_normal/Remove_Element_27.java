package titles.two_pointers.variants_normal;

public class Remove_Element_27 {
}

class Solution_27 {

    // 1. 正解：直接把非val移到前面
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i]!=val)
                nums[k++] = nums[i];
        }
        return k;
    }

    // 2. 自己想的，能过大部分用例，如果数组不包含val不行
    // 排序，二分找出首尾，根据首尾移除（赋值-1）
    // boolean isConclude = true;
    // public int removeElement(int[] nums, int val) {
    //     if (nums.length==0)
    //         return 0;
    //     Arrays.sort(nums);
    //     int l = findLowBound(nums,val);
    //     int r = findUpBound(nums,val);
    //     int end = nums.length-1;
    //     for (;r>=l;--r){
    //         nums[r] = -1;
    //         swap(nums,r,end--);
    //     }
    //     return end+1;
    // }

    // // 找第一个大于等于val的位置
    // private int findLowBound(int[] nums, int val) {
    //     int l=0, r=nums.length-1;
    //     while(l<r) {
    //         int mid = ((l+r)>>1);
    //         if (nums[mid]>=val) {
    //             r = mid;
    //         }else{
    //             l = mid+1;
    //         }
    //     }
    //     return l;
    // }

    // // 找第一个大于val的位置-1
    // private int findUpBound(int[] nums, int val) {
    //     int l=0, r=nums.length-1;
    //     while(l<r) {
    //         int mid = ((l+r)>>1);
    //         if (nums[mid]>val) {
    //             r = mid;
    //         }else{
    //             l = mid+1;
    //         }
    //     }
    //     return nums[l] > val ? l-1 : l;
    // }

    // private void swap(int[] nums, int l, int r) {
    //     int tmp = nums[l];
    //     nums[l] = nums[r];
    //     nums[r] = tmp;
    // }
}
