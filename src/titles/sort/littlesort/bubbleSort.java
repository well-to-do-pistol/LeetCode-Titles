package titles.sort.littlesort;

public class bubbleSort {
}
class Solution_bubbleSort {

    public int[] sortArray(int[] nums) {
        for (int i=0; i<nums.length-1; i++){
            for (int j=0; j<nums.length-i-1; j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }
}