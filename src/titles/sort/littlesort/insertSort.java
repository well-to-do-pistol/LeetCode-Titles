package titles.sort.littlesort;

public class insertSort {
}
class Solution_insertSort {

    public int[] sortArray(int[] nums) {
        for (int i=1; i<nums.length; i++){
            int x = nums[i];
            int j=i-1;
            while (j>=0 && nums[j]>x){
                nums[j+1]=nums[j];
                --j;
            }
            nums[j+1]=x;
        }
        return nums;
    }
}