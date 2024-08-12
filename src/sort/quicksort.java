package sort;

//每次确定一个中心点，然后再分别确定两边中心点，不断递归，确定所有的点
public class quicksort {

    void quickSortMy(int[] nums, int low, int high){
        if (low<high){
            int mid = partitionMy(nums, low, high);
            quickSortMy(nums,low,mid-1);
            quickSortMy(nums,mid+1,high);
        }
    }

    private int partitionMy(int[] nums, int low, int high) {
        int judge = nums[high];
        int left = low-1;
        for (int i=low; i<high; i++){
            if (nums[i]<=judge){
                left++;
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
            }
        }
        //其他都是大于的，在右边
        int temp = nums[left+1];
        nums[left+1] = nums[high];
        nums[high] = temp;
        return left+1;
    }
}
//34675
//5
//34 //5 //67

//