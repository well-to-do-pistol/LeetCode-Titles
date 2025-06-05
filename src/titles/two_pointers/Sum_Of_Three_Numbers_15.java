package titles.two_pointers;

import java.util.*;

public class Sum_Of_Three_Numbers_15 {
}
class Solution_15 {
    // 注意i要去重，
    // 得到新结果，还是要继续遍历，因为i已经定了，继续遍历要先去重而且用while
    // Arrays.asList
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len<3)return res;
        Arrays.sort(nums);
        for(int i=0; i<len-2; ++i){
            if(i!=0 && nums[i-1]==nums[i])continue; //i不为0时, 禁止第一个数出现重复
            int x = -nums[i];
            int low = i+1;
            int high = len-1;
            while(low<high){
                if(nums[low]+nums[high]==x){
                    res.add(Arrays.asList(-x,nums[low],nums[high]));
                    while(low<high && nums[low+1]==nums[low])++low;    //去掉和答案相同的第二个数
                    while(low<high && nums[high-1]==nums[high])--high; //去掉和答案相同的第三个数
                    ++low;  //第一个数已经确定, 直接排除两个数
                    --high;
                }else if(nums[low]+nums[high]<x)
                    ++low;
                else //nums[low]+nums[high]>x
                    --high;
            }
        }
        return res;
    }
}