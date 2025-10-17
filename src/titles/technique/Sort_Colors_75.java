package titles.technique;

public class Sort_Colors_75
{
}


class Solution_75 {
    /**
     1. 最佳写法,这是荷兰国旗问题
     */
    // 简化版：两次判断可以优化成一次：即0放了，0和1都加，中间只需要判断1是否大于0，只要大肯定需要再移动一次(1)
    public void sortColors(int[] nums) {
        int zeroE=0, oneE=0;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i]==0) {
                swap(nums,zeroE,i);
                if (oneE>zeroE) {
                    swap(nums,oneE,i);
                }
                ++zeroE;
                ++oneE;
            } else if (nums[i]==1) {
                swap(nums,oneE++,i);
            }
        }
    }

    /**
     2. 自己想的，可以简化成最优的版本
     */
    // 只排列01,2自然就排了
    // 0放了，只有1>0时，1才加；1放了，0不用加
//    public void sortColors(int[] nums) {
//        int zeroE=0, oneE=0;
//        for (int i=0; i<nums.length; ++i) {
//            if (nums[i]==0) {
//                swap(nums,zeroE++,i);
//                if (zeroE>oneE) oneE++;    // 这里是重点
//                if (nums[i]==1) {
//                    swap(nums,oneE++,i);
//                }
//            } else if (nums[i]==1) {
//                swap(nums,oneE++,i);
//            }
//        }
//    }

    private void swap (int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
