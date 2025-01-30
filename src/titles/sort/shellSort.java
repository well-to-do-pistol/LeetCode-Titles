package titles.sort;

public class shellSort {
}
class Solution_shellSort {

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int interval=n/2; interval>0; interval/=2){
            for (int i=interval; i<n; ++i){
                int x=nums[i];
                int j=i-interval;
                while (j>=0 && nums[j]>x){
                    nums[j+interval]=nums[j];
                    j-=interval;
                }
                nums[j+interval]=x;
            }
        }
        return nums;
    }
}
