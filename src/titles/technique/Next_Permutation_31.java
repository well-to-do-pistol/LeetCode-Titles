package titles.technique;

public class Next_Permutation_31 {
}
class Solution_31 {
    // 可以具体看力扣题解。就是找左边较小数，找右边较大数，较小数要靠右，叫较大数尽可能小，然后交换这两个数；较小数右边要变成升序因为这样能最小
    // 如果较小数找到了-1，直接反转整个数组(就是整个数组都是降序的情况),可以整合到较小数右边变成升序的逻辑
    // 找较小数，直接找第一个升序对的i（左边），所以从n-2开始
    // 找较大数，直接找第一个j大于i
    // 如果要变成升序，直接反转就行，因为右边的一定不是升序
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while (i>=0 && nums[i]>=nums[i+1]) {
            --i;
        }
        if (i>=0){
            int j = n-1;
            while(j>0 && nums[i]>=nums[j]) {
                --j;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,n-1);
    }

    private void reverse (int[] nums, int l, int r) {
        while(l<r){
            swap(nums,l,r);
            ++l;
            --r;
        }
    }

    private void swap (int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}