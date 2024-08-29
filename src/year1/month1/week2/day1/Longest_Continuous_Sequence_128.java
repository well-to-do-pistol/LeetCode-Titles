package year1.month1.week2.day1;

import java.util.HashSet;
import java.util.Set;

public class Longest_Continuous_Sequence_128 {
}
class Solution_128 {
    //将所有数加入集合
    //遍历找num+1的树
    //如果存在num-1则跳过
    //1234
    //678
    //10 11 保证了每个数只会被遍历一次, 只遍历起点
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n:nums)set.add(n);

        int longest=0;
        for (int s:set){
            if (!set.contains(s-1)){
                int curNum=s;
                int sequence=1; //有一个起点了
                while (set.contains(curNum+1)){ //只要有+1就不停遍历
                    curNum+=1; //指向下一个数
                    sequence+=1;
                }
                longest=Math.max(longest,sequence);
            }
        }
        return longest;
    }
}