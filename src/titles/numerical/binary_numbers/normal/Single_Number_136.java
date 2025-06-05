package titles.numerical.binary_numbers.normal;

public class Single_Number_136 {
}
class Solution_136 {
    // 从0开始，异或每一个数
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums){
            res ^= num;
        }
        return res;
    }
}