package titles.array;

public class Product_Except_Self_238 {
}

class Solution_238 {
    // 记录每个索引左乘积和
    // 总共只用一个数组，最后倒序计算结果，用R表示左乘积和
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0]=1;
        for (int i=1; i<n; ++i) {
            res[i] = res[i-1]*nums[i-1];
        }
        int R=1;
        for (int i=n-1; i>=0; --i) {
            res[i] = res[i]*R;
            R*=nums[i];
        }
        return res;
    }
}