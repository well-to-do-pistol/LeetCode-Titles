package titles.technique;

public class Sort_Colors_75
{
}


class Solution_75 {
    /**
     1. 最佳写法,这是荷兰国旗问题
     */
    // 优先换1，换0时如果oneEnd>zeroEnd证明会把1换出来，再换一次，然后++两者
    public void sortColors(int[] nums) {
        int zeroEnd = 0, oneEnd = 0;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i] == 1) {
                swap(nums,oneEnd,i);
                ++oneEnd;
            } else if (nums[i] == 0) {
                swap(nums,zeroEnd,i);
                if (oneEnd > zeroEnd) {
                    swap(nums,oneEnd,i);
                }
                ++zeroEnd;
                ++oneEnd;
            }
        }
    }

    /**
     2. 可读性差，自己想的
     */
    // 只换0和1，如果换回来是1的话，继续换
    // public void sortColors(int[] nums) {
    //     int zeroEnd = 0, oneEnd = 0;
    //     for (int i=0; i<nums.length; ++i) {
    //         if (nums[i] == 0) {
    //             swap(nums,zeroEnd,i);
    //             ++zeroEnd;
    //             if (nums[i] == 1) {
    //                 swap(nums,oneEnd,i);
    //                 ++oneEnd;
    //             }
    //         } else if (nums[i] == 1) {
    //             while (nums[oneEnd] == 0)
    //                 ++oneEnd;
    //              swap(nums,oneEnd,i);
    //                 ++oneEnd;
    //         }
    //     }
    // }

    private void swap (int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
