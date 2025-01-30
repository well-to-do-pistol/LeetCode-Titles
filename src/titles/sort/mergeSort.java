package titles.sort;

public class mergeSort {
}
class Solution_mergeSort {

    public int[] sortArray(int[] nums) {
        patition(nums,0,nums.length-1);
        return nums;
    }
    private void patition(int[] nums, int l, int r){
        if (l==r)return;
        int mid = l+((r-l)>>1);
        patition(nums,l,mid);
        patition(nums,mid+1,r);
        mergeSort(nums,l,mid,r);
    }
    private void mergeSort(int[] nums, int l, int mid, int r){
        int i=0;
        int p1=l;
        int p2=mid+1;
        int[] tmp = new int[r-l+1];
        while (p1<=mid && p2<=r)
            tmp[i++] = nums[p1]<=nums[p2] ? nums[p1++] : nums[p2++];
        while (p1<=mid)
            tmp[i++] = nums[p1++];
        while (p2<=r)
            tmp[i++] = nums[p2++];
        for(int j=0; j<tmp.length; j++)
            nums[l++]=tmp[j];
    }
}