package titles.sort;

public class heapSort {
}
class Solution_heapSort {

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        //1.大根堆(1 2 3 4, 1 2 3)
        for (int i=n/2-1; i>=0; --i){
            heapify(nums,i,n);
        }
        //2.将每个根移到最后,heapify
        for (int i=n-1; i>=0; --i){
            int tmp=nums[0];
            nums[0]=nums[i];
            nums[i]=tmp;
            heapify(nums,0,i);
        }

        return nums;
    }

    private void heapify(int[] nums, int i, int n){
        int l=2*i+1;
        int r=2*i+2;
        int large=i;
        if (l<n && nums[l]>nums[large])large=l;
        if (r<n && nums[r]>nums[large])large=r;
        if(large!=i){
            int tmp = nums[i];
            nums[i] = nums[large];
            nums[large] = tmp;
            heapify(nums,large,n);
        }
    }

}