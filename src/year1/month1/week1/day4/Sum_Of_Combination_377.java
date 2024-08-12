package year1.month1.week1.day4;

public class Sum_Of_Combination_377 {
}

class Solution_377 {
    //完全背包的目标和的遍历顺序：
    //先物品再背包：组合
    //先背包再物品：排列
    //这里是求排列

    //为什么先背包后物品就是排列呢？
    //第1轮： dp[1]+=dp[0]=1

    //第2轮： dp[2]+=dp[2-1]=1
    //第2轮： dp[2]+=dp[2-2]=2

    //第3轮： dp[3]+=dp[3-1]=2   最后一个是1， 2，1 ； 1，1，1
    //第3轮： dp[3]+=dp[3-2]=3   最后一个是2， 1，2
    //第3轮： dp[3]+=dp[3-3]=4   最后一个是3， 3

    //第4轮： dp[4]+=dp[4-1]=4   最后一个是1， 1，2，1 ； 1，1，1，1 ； 2，1，1； 3，1
    //第4轮： dp[4]+=dp[4-2]=6   最后一个是2， 1，1，2 ； 2，2
    //第4轮： dp[4]+=dp[4-3]=7   最后一个是3， 1，3

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;

        for (int j=0; j<=target; j++){
            for (int i=0; i<nums.length; i++){
                if (j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}