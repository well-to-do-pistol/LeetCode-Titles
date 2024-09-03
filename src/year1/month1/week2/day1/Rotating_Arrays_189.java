package year1.month1.week2.day1;

public class Rotating_Arrays_189 {
}
class Solution_189 {
    //先翻转数组
    //再翻转0,k%n-1
    //再翻转k%n,n-1
    //1234567
    //7654321
    //5674321
    //5671234
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        reverseM(nums,0,n-1);
        reverseM(nums,0,k%n-1);
        reverseM(nums,k%n,n-1);
    }

    private void reverseM(int[] nums, int a, int b) {
        for (;a<b;a++,b--){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
        }
    }
}

