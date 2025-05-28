package titles.binary_search;

public class Search_For_The_Insertion_Position_35 {
}
class Solution_35 {
    //就找大于等于target的
    public int searchInsert(int[] nums, int target) {
        int l=0, r=nums.length-1, ans=r+1, mid;
        while(l<=r){
            mid = l+((r-l)>>1);
            if (nums[mid]>=target){
                ans = mid;
                r = mid-1;
            } else{
                l = mid+1;
            }
        }
        return ans;
    }
}