package year1.month1.week1.day3;

import java.util.ArrayList;
import java.util.List;

public class Divide_Letter_Intervals_763 {
}
class Solution2 {
    //a,b,c,a,d,d,e
    //3,1,2,3,4,5,6
    //记录字符串每个字母的最远下标
    //遍历字符串，遍历到最远下标对应的索引为止，计算长度，迭代
    //利用另一个数组帮忙记录最远下标
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[27];
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        for (int i=0; i<len; i++){
            hash[charArray[i]-'a']=i;
        }
        int left=0,right=0;
        for (int i=0; i<len; i++){
            right=Math.max(right,hash[charArray[i]-'a']);//找到当前字母的最远距离，更新右边界
            if (right==i){
                res.add(right-left+1);
                left=right+1;
            }
        }
        return res;
    }
}