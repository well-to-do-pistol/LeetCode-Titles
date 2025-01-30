package titles.sort;

import java.util.Random;

public class quickSort {
}
class Solution_quickSort {
    //10以内用插入
    public int[] sortArray(int[] nums) {
        patition(nums,0,nums.length-1);
        return nums;
    }
    private void patition(int[] nums, int l, int r){
        if (l>=r)return;
        if(r-l<9){
            insertSort(nums,l,r);
            return;
        }
        int mid = randomQuickSort(nums,l,r);
        patition(nums,l,mid-1);
        patition(nums,mid+1,r);
    }

    Random random = new Random();
    private int randomQuickSort(int[] nums, int l, int r){
        int i=random.nextInt(r-l+1)+l;
        swap(nums,r,i);
        return quickSort(nums,l,r);
    }

    private int quickSort(int[] nums, int l, int r){
        numOfThree(nums,l,r);
        int numX = nums[r];
        int left=l-1;
        for (int i=l; i<r; i++){
            if(nums[i]<numX){
                swap(nums,++left,i);
            }
        }
        swap(nums,++left,r);
        return left;
    }

    private void insertSort(int[] nums, int l, int r){
        for (int i=l+1; i<=r; ++i){
            int tmp = nums[i];
            int j=i-1;
            while (j>=l && nums[j]>tmp){
                nums[j+1]=nums[j];
                --j;
            }
            nums[j+1]=tmp;
        }
    }

    private void numOfThree(int[] nums, int l, int r){
        int mid = l+((r-l)>>1);
        if (nums[mid]>nums[l])swap(nums,l,mid);
        if (nums[r]>nums[l])swap(nums,l,r);
        if (nums[mid]>nums[r])swap(nums,mid,r);
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] =  nums[b];
        nums[b] = tmp;
    }
}