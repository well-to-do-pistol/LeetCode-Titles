package year1.month1.week1.day3;

import java.util.Arrays;
import java.util.Comparator;

public class No_Overlapping_Interval_435 {
}

class Solution {
    //[1,3]和[3,4]不算重叠
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len==0)return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]>o2[0]){
                    return 1;
                }else if (o1[0]<o2[0]){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        int res = 0;
        for (int i=1; i<len; i++){
            if (intervals[i][0]<intervals[i-1][1]){
                res++;
                intervals[i][1]=Math.min(intervals[i-1][1],intervals[i][1]); //一定要求最小值
            }
        }
        return res;
    }
}
