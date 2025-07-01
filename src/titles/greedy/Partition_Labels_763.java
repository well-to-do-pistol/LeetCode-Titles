package titles.greedy;
import java.util.*;
public class Partition_Labels_763
{
}
class Solution_763 {
    // 划分片数尽可能多，同一字母只能出现在同一片
    // 先用26数组记录所有字母的最远索引
    // 遍历字符串，更新r为当前字母最远索引
    // 如果i==r，证明到边界了，插入r-l+1，更新l
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] farthests = new int[26];
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; ++i)
            farthests[chars[i]-'a']=i;
        int l=0, r=0;
        for (int i=0; i<chars.length; ++i){
            r = Math.max(r,farthests[chars[i]-'a']);
            if (i==r){
                res.add(r-l+1);
                l = r+1;
            }
        }
        return res;
    }
}