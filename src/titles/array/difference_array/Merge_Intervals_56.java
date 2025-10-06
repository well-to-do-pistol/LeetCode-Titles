package titles.array.difference_array;

import java.util.*;

public class Merge_Intervals_56 {
}


class Solution_56 {

    // -1. 我的最新写法：
    // 左小于等于右，就变；其余直接加
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0], end=intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int[] nums:intervals) {
            if (nums[0]<=end) {
                end = Math.max(end,nums[1]);
            } else {
                res.add(new int[]{start,end});
                start = nums[0];
                end = nums[1];
            }
        }
        res.add(new int[]{start,end});
        int[][] numbers = new int[res.size()][2];
        for (int i=0; i<res.size(); ++i) {
            numbers[i] = res.get(i);
        }
        return numbers;
    }


    // 0. (最快)使用差分数组(对区间加减时使用的)
    // 先遍历找到最大的end, 利用这个值创建diff
    // 如果是start, 映射到diff为i*2; 如果是end, 映射到diff为i*2+1
    // start在diff里是++, end在diff里是--; 最后遍历形成结果数组, 用s+=diff[i]记录总和, s>0证明是开头, s==0证明是结尾
    // 确保start和end的点在diff不重叠不影响计算, 比如[1,4]和[5,6], 不*2的话区间就会合并导致错误
//    public int[][] merge(int[][] intervals) {
//        List<int[]> res = new ArrayList<>();
//        int e=0;
//        for(int[] interval : intervals)
//            if(interval[1]>e)e=interval[1];
//        int n=(e<<1)+2;
//        int[] diff = new int[n];
//        for(int[] interval : intervals){
//            ++diff[interval[0]<<1];
//            --diff[(interval[1]<<1)+1];
//        }
//        int s=0, start=-1;                //用start确认是否确定了开头
//        for(int i=0; i<n; ++i){
//            s+=diff[i];
//            if(s>0 && start==-1){
//                start=i;
//            }else if(s==0 && start!=-1){
//                res.add(new int[]{start>>1, (i-1)>>1});
//                start=-1;
//            }
//        }
//        return res.toArray(new int[0][0]);
//    }


    // 1. 使用链表, 用res.toArray(new int[res.size][])将链表转换成二维数组
    // [1,4],[1,5] 与 [1,5],[1,4] 作为排序结果都可以
    // public int[][] merge(int[][] intervals) {
    //     int n=intervals.length;
    //     Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
    //     Deque<int[]> res = new LinkedList<>();
    //     res.offer(intervals[0]);
    //     for(int i=1; i<n; ++i){
    //         if(res.peekLast()[1] >= intervals[i][0]){
    //             if(res.peekLast()[1] >= intervals[i][1])continue;
    //             res.peekLast()[1]=intervals[i][1];
    //         }else
    //             res.offer(intervals[i]);
    //     }
    //     return res.toArray(new int[res.size()][]);
    // }


    // 2.自己想的，跟最快写法稍微有点不同
//    public int[][] merge(int[][] intervals) {
//         List<int[]> res = new ArrayList<>();
//         Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//         res.add(intervals[0]);
//         for (int i=1; i<intervals.length; ++i) {
//             int[] tmp = res.get(res.size()-1);
//             if (intervals[i][0]>tmp[1]) {
//                 res.add(intervals[i]);
//             } else {
//                 tmp[0] = Math.min(tmp[0],intervals[i][0]);
//                 tmp[1] = Math.max(tmp[1],intervals[i][1]);
//             }
//         }
//         int[][] result = new int[res.size()][2];
//         for (int i=0; i<res.size(); ++i) {
//             result[i] = res.get(i);
//         }
//         return result;
//     }
}