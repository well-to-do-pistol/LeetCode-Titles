package titles.two_pointers;

import  java.util.*;

public class Mobile_Zero_283 {
}
class Solution_283 {

    // 1. 双指针法
    // 左右指针置零, 用右指针遍历数组, 一旦遇到非零赋给左指针, ++左指针; 最后用左指针遍历数组把后面的数全赋为零
    public void moveZeroes(int[] nums) {
        int left=0, right=0, len=nums.length;
        while(right<len){
            if(nums[right]!=0){
                nums[left++]=nums[right];
            }
            ++right;
        }
        while(left<len){
            nums[left++]=0;
        }
    }

    // 2. 插入排序法, 耗时很高(自己想的)
    // public void moveZeroes(int[] nums) {
    //     int len = nums.length;
    //     for(int i=len-2; i>=0; --i){
    //         int x = nums[i]; //要插入的0
    //         int j = i+1;     //末尾非零数组的起点
    //         if(x==0){
    //             while(j<len && nums[j]!=0){
    //                 nums[j-1]=nums[j];  //给插入的0腾位置
    //                 ++j;
    //             }
    //             nums[j-1]=0;
    //         }
    //     }
    // }

    //插入排序
    private void insertSort(int[] nums){
        for(int i=1; i<nums.length; ++i){
            int x = nums[i]; //要插入的元素
            int j = i-1;     //已排序数组的末尾
            while(j>=0 && nums[j]>x){
                nums[j+1]=nums[j];  //比x大的话要腾出位置给x
                --j;
            }
            nums[j+1] = x;          //最后会多减一次所以要+1
        }
    }
}