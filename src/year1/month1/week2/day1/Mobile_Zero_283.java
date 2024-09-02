package year1.month1.week2.day1;

public class Mobile_Zero_283 {
}
class Solution_283 {
    //定义左右指针
    //每次移动右指针遍历节点,一旦找到非零,直接变成左指针的数,左指针右移,然后最后遍历左指针把后面的数都赋为0
    public void moveZeroes(int[] nums) {
        int left=0;
        int right=0;
        int len=nums.length;
        while (right<len){
            if (nums[right]!=0){
                nums[left++]=nums[right];
            }
            right++;
        }
        while (left<len){
            nums[left++]=0;
        }
    }
}