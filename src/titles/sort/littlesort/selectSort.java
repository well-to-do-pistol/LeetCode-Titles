package titles.sort.littlesort;

public class selectSort {
}
class Solution_selectSort {

    public int[] sortArray(int[] nums) {
        for (int i=0; i<nums.length-1; i++){
            int min=i;
            for (int j=i+1; j<nums.length; j++){
                if (nums[j]<nums[min]){
                    min=j;
                }
            }
            int tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}