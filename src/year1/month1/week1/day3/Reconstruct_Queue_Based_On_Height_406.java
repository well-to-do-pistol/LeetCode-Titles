package year1.month1.week1.day3;

import java.util.Arrays;
import java.util.LinkedList;

public class Reconstruct_Queue_Based_On_Height_406 {

}

class Solution5 {
    //两个维度，一定要先确定一个，再确定另一个
    //先用k排序试试, 再用h排序试试，最后发现先排h, 再根据k直接插到序列为k的地方
    //使用linkedlist方便插入
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if (a[0]==b[0]){
                return a[1]-b[1];//如果h相等，按照k升序排序
            }
            return b[0]-a[0];
        });//基础规则是按照h降序
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] num:people){
            res.add(num[1],num); //按照k对应索引来插入
        }
        return res.toArray(new int[people.length][]);
    }
}
