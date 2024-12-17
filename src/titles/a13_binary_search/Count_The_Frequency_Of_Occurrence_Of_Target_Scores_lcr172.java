package titles.a13_binary_search;

public class Count_The_Frequency_Of_Occurrence_Of_Target_Scores_lcr172 {
}
//用upperbound和lowerbound解决
class Solution_lcr172 {
    public int countTarget(int[] scores, int target) {
        int l=lowerbound(scores,0,scores.length,target);
        int r=upperbound(scores,0,scores.length,target);
        if(l<scores.length && scores[l]==target){
            return r-l;
        }
        return 0;
    }

    //x<=y(mid)
    int lowerbound(int[] nums, int l, int r, int target){
        int mid;
        while(l<r){
            mid=l+((r-l)>>1);
            if(target>nums[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }

    //x<y(mid)
    int upperbound(int[] nums, int l, int r, int target){
        int mid;
        while(l<r){
            mid=l+((r-l)>>1);
            if(target>=nums[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}