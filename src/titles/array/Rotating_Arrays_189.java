package titles.array;

import java.util.*;

public class Rotating_Arrays_189 {
}

class Solution_189 {

    // [0,n-k-1]反转, [n-k,n-1]反转, [0,n-1]反转
    // k是长度不是索引!, k有可能比长度还大, 要%=n
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        swap(nums,0,n-k-1);
        swap(nums,n-k,n-1);
        swap(nums,0,n-1);
    }

    private void swap(int[] nums, int l, int r){
        while(l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            ++l;
            --r;
        }
    }
}