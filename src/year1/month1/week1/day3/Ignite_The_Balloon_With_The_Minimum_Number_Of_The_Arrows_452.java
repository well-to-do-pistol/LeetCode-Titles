package year1.month1.week1.day3;

import sun.applet.Main;

import java.util.Arrays;
import java.util.Comparator;

public class Ignite_The_Balloon_With_The_Minimum_Number_Of_The_Arrows_452 {
}

class Solution3 {
    //先根据a排序，这样重叠的就更有可能在一起
    //再判断第二个的左边界是否大于第一个的右边界
    //如果重叠了，必须更新第二个的右边界，方便下一次比较
    //箭从1开始
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len==0)return 0;

//        Arrays.sort(points,(a,b)->{return a[0]-b[0];});
        // 按 points[0] 进行升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int res = 1;
        for (int i=1; i<len; i++){
            if (points[i][0]>points[i-1][1]){
                res++;
            }else {
                points[i][1]= Math.min(points[i-1][1],points[i][1]); //一定要求最小值
            }
        }
        return res;
    }
}
