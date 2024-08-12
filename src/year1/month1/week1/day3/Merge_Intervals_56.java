package year1.month1.week1.day3;

import java.util.*;

public class Merge_Intervals_56 {
    public static void main(String[] args) {
        Solution1 res = new Solution1();
        //[[2,3],[4,5],[6,7],[8,9],[1,10]]
        int[][] n = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        res.merge(n);
    }
}

    class Solution1 {
        //重点是合并区间
        //另外比较是和链表的最后一个比较，不是用原数组的前一个比较（不准，因为可能前面已经形成了大区间[1, 10],[2, 3],[4, 5], 又用[2, 3]比会多出数组）
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len==0)return null;

            Arrays.sort(intervals, (o1, o2)->{return o1[0]-o2[0];});
            LinkedList<int[]> res = new LinkedList<>();
            res.add(intervals[0]);
            for (int i=1; i<len; i++){
                if (intervals[i][0] <= res.getLast()[1]){
                    int start = res.getLast()[0];
                    int end = Math.max(res.getLast()[1], intervals[i][1]);
                    res.removeLast();
                    res.add(new int[]{start,end});
                }else {
                    res.add(intervals[i]);
                }
            }
            return res.toArray(new int[res.size()][]); //数组链表变成数组 只需要toArray()和new int[size][];
        }

    }
