package year1.month1.week1.day5;

public class Sum_Of_The_Largest_Subarrays_53 {
    public static void main(String[] args) {
        Solution_53 solution53 = new Solution_53();
        solution53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}

//注意⚠️！！！ [-2,1]的时候，从前往后遍历，没事；从后往前遍历，就要考虑了，所以只有两个数不能一下子比较完，一步一步比

class Solution_53 {
    //贪心：先把和加上，一旦小于0清零
    //要有一个max取最大值，不然遇到负数不小于0又加上了
//    public int maxSubArray(int[] nums) {
//        int sum=0;
//        int max=Integer.MIN_VALUE;
//        for (int i=0; i<nums.length; i++){
//            sum+=nums[i];
////            System.out.println(sum);
//            max=Math.max(max,sum); //加上了之后再求max, 不然只有一个数的情况得不到加上的值
//            if (sum<0)sum=0;
//        }
//        return max;
//    }


    //动态规划
    //从后向前遍历，dp[i]代表考虑nums[i]之后的最大和
    //从前向后的弊端：不知道后面有没有大的数
//    public int maxSubArray(int[] nums) {
//        int len=nums.length;
//        int[] dp = new int[len];
//
//        int max=Integer.MIN_VALUE;
//        for (int i=len-1; i>=0; i--){
//            if (i==len-1){
//                dp[i]=nums[i];
//            }else {
//                dp[i]=dp[i+1]+nums[i];
//            }
//            max=Math.max(dp[i],max);  //先取max再清零，因为可能答案就是要负数
//            if (dp[i]<0)dp[i]=0;     //要清零的
//        }
//        return max;
//    }



    //动态规划2
    //dp[i]为以nums[i]为结尾的最大子数组和
    //延续之前的值dp[i-1]+nums[i]
    //不延续nums[i]
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];

        int max = nums[0];
        for (int i=1; i<nums.length; i++){
            dp[i]=Math.max( dp[i-1]+nums[i], nums[i] );
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}