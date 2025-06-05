package titles.numerical.binary_numbers;

public class Count_Bits_338 {
}

class Solution_338 {
    // 用i&(i-1)计数 (因为计算单个时，i=i&(i-1)，然后计数+1，我们就能根据前面小于该数的已计算结果得出最终结果了，详见numerical/binary_numbers/norml/Hamming_Weight)
    // 继续优化，则res[i] = res[i&(i-1)]+1, 从索引1开始
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i=1; i<=n; ++i){
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }


}

// 方法2，和方法1两个都可以
//class Solution_338 {
//    // 利用i>>1索引位置的结果，(判断奇偶直接异或1)当前数是奇数就+1，是偶数就+0
//    // 3为2， 6为2， 7为3 以此类推
//    public int[] countBits(int n) {
//        int[] res = new int[n+1];
//        for (int i=1; i<=n; ++i){
//            res[i] = res[i>>1]+(i&1);  // &要加括号
//        }
//        return res;
//    }
//}