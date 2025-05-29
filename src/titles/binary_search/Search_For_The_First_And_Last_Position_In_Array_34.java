package titles.binary_search;

public class Search_For_The_First_And_Last_Position_In_Array_34 {
}
class Solution_34 {
    // 找大于等于的res，就是找插入位置
    // 找小于等于的res，就是找
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        int l = findL(nums,target,n);
        int r = findR(nums,target,n);
        res[0] = l==n ? -1 : (nums[l]==target ? l : -1);
        res[1] = r==n ? -1 : (nums[r]==target ? r : -1);
        return res;
    }

    private int findL(int[] nums, int target, int n){
        int res = n;
        int l = 0, r = n-1, mid;
        while(l<=r){
            mid = l+((r-l)>>1);
            if(nums[mid]>=target){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }

    private int findR(int[] nums, int target, int n){
        int res = n;
        int l = 0, r = n-1, mid;
        while(l<=r){
            mid = l+((r-l)>>1);
            if(nums[mid]<=target){
                res = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return res;
    }
}

/**
 * 备选解法
 */
//class Solution {
//    //两次二分
//    public int[] searchRange(int[] nums, int target) {
//        int leftI = BinearSearch(true,nums,target);
//        int rightI = BinearSearch(false,nums,target)-1;
//        if (leftI<=rightI && nums[leftI]==target && nums[rightI]==target){
//            return new int[]{leftI,rightI};
//        }
//        return new int[]{-1,-1};
//    }
//
//    private int BinearSearch(boolean lower, int[] nums, int target) {
//        int ans = nums.length, l=0, r=nums.length-1;
//        while (l<=r){
//            int mid = ((r-l)>>1)+l;
//            if (nums[mid]>target || (lower && nums[mid]>=target)){
//                r=mid-1;
//                ans=mid;
//            }else {
//                l=mid+1;
//            }
//        }
//        return ans;
//    }
//}