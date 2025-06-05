package titles.numerical.binary_numbers;

public class Single_Number_137 {
}


class Solution_137 {
    // 每个数的全部32位相加然后模3，得到的只出现1次数的该位数
    // 最后是遍历数组32次，每次<<1，然后加上模3的值
    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        for (int num:nums){
            for (int i=0; i<32; ++i){
                res[i] += (num >> (31-i) & 1); // 先右移31位不是32位
            }
        }
        int ans = 0;
        for (int i=0; i<32; ++i){
            ans = (ans<<1)+res[i]%3;
        }
        return ans;
    }
}