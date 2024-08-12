package year1.month1.week1.day4;

public class The_Weight_Of_The_Last_Stone_II_1049 {
}
class Solution {
    //转化成0-1背包其实是分割等和子集问题
    //结果为总和-dp[总和一半]-dp[总和一半] //因为向下取整，所以一定得到正数
    //重量就是价值
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum=0;
        for (int i=0; i<len; i++){
            sum+=stones[i];
        }
        int total=sum;
        sum/=2;

        int[] dp = new int[sum+1];
        for (int i=0; i<len; i++){ //先塞小的
            for (int j=sum; j>=stones[i]; j--){
                dp[j] = Math.max( dp[j] , dp[j-stones[i]] + stones[i] );
            }
        }
        return total-dp[sum] * 2;
    }
}