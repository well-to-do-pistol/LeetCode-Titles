package titles.array;

public class Find_Max_Min_C {
}
class Solution {
    //  两两比较
// 偶数先比较前两个，奇数maxmin=nums[0]
    private int[] findMaxMin(int[] nums) {
        int n = nums.length;
        if (n==0)
            return new int[0];
        int max,min,i;
        if ((n&1)==0) {
            if (nums[0]>=nums[1]){
                max = nums[0];
                min = nums[1];
            } else {
                max = nums[1];
                min = nums[0];
            }
            i = 2;
        } else {
            max = min = nums[0];
            i = 1;
        }

        while (i<n-1) { //只是更健壮，不用n-1的其实，n就行
            int localMax, localMin;
            if (nums[i] >= nums[i+1]) {
                localMax = nums[i];
                localMin = nums[i+1];
            } else {
                localMax = nums[i+1];
                localMin = nums[i];
            }
            if (localMax>max)
                max=localMax;
            if (localMin<min)
                min=localMin;
            i+=2;
        }
        return new int[]{max,min};
    }
}