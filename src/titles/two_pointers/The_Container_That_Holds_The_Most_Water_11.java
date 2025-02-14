package titles.two_pointers;

import  java.util.*;

public class The_Container_That_Holds_The_Most_Water_11 {
}
class Solution_11 {
    // 计算较短线, 如果哪边较短收敛哪边
    // 2*4<3*3(数学原理吧)
    public int maxArea(int[] height) {
        int len = height.length;
        int l=0, r=len-1, max=0;
        //面积等于Math.min(height[l],height[r])*(r-l)
        while(l<r){
            int shorter=Math.min(height[l],height[r]);
            max=Math.max(shorter*(r-l),max);
            while(height[l]==shorter && l<r)++l;
            while(height[r]==shorter && l<r)--r;
        }
        return max;
    }
}