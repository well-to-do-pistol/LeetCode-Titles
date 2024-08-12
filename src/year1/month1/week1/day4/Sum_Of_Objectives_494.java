package year1.month1.week1.day4;

public class Sum_Of_Objectives_494 {
}
class Solution_494 {
    //0-1背包：1.分割等和子集：求容量装满的价值等于容量；2.最后一块石头II:尽量装满求两集合总和之差；
    //目标和：求装满有多少种方法
    //dp[j]+=dp[j-nums[i]] //⚠️注意：初始化dp[0]=1,因为要累加方法总数

    //如何转化为0-1背包问题：
    //分为整数集合和负数集合：
    //left+right=sum
    //left-right=target
    //left=(sum+target)/2 //如果是奇数则说明不能凑出target
    //如11111 3 left=4    //问题变成装满4容量有多少种方法
    //如11111 2 直接return 0
    //如果100 -201 直接return 0

    //依旧是先遍历物品再遍历容量，遍历容量时倒序（每个物品只遍历一次，并且不能让前面的结果影响后面的）
    public int findTargetSumWays(int[] nums, int target) {
        int len=nums.length;
        int sum=0;
        for (int i=0; i<len; i++){
            sum+=nums[i];
        }
        if (Math.abs(target)>sum)return 0; //绝对值大于sum不行
        if ((sum+target)%2!=0)return 0;    //奇数不行
        int left = (sum+target)/2;

        int[] dp = new int[left+1];
        dp[0]=1;
        for (int i=0; i<len; i++){ //一个个塞
            for (int j=left; j>=nums[i]; j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[left];
    }
}