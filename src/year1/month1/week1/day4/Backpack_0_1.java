package year1.month1.week1.day4;

import java.util.Arrays;

public class Backpack_0_1 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
//        testWeightBagProblem(weight,value,bagSize);
        oneDimensionalDP(weight,value,bagSize);
    }

    //一维数组
    //dp[j]= Math.max( dp[j] , dp[j-weigh[i]] + value[i] )
    //1.为什么先遍历物品后遍历容量：确保每件物品只放一次，如果不这样物品会重放
    //2.为什么遍历容量时从后往前遍历：dp[j]需要dp[j-n](n>0)的数据支持，如果从前往后，则dp[j-n]的数据会影响dp[j]:  dp[2]=dp[2-1]+15 = 15 (错误情况是30因为dp[1]已经是15了)
    //也是确保了每件物品只放一次
    //3.为什么要两层循环：因为要遍历所有情况
    private static void oneDimensionalDP(int[] weight, int[] value, int bagSize) {
        int len = bagSize+1;
        int[] dp = new int[len];
        for (int i=0; i<weight.length; i++){
            for (int j=bagSize; j>=weight[i]; j--){
                dp[j] = Math.max( dp[j] , dp[j-weight[i]] + value[i] );
            }
        }
        System.out.println(Arrays.toString(dp));
    }


    //思路：dp[i][j]为使用第i个以及第i之前的物品在容量为j时得到的最大价值
    //1.不放第i个物品，dp[i-1][j]
    //2.放第i个物品,Math.max( dp[i-1][j-weigh[i]]+value[i] ,  dp[i-1][j] ) : 最后的物品可能占重过大，价值较小，所以取最大值

    //         容量1    容量2    容量3
    //物品0
    //物品1
    //物品2
    //初始化第一行和第一列
    //先遍历容量还是物品， 都可以

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int row = weight.length;
        int col = bagSize+1;
        int[][] dp = new int[row][col];
//        Arrays.fill(dp,0);

        for (int j=1; j<col; j++){
            dp[0][j] = j>=weight[0] ? value[0] : 0;
        }

        for (int i=1; i<row; i++){
            for (int j=1; j<col; j++){
                if (j<weight[i]){         //只有当前容量过少才选择不添加
                    dp[i][j]  = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max( dp[i][j-weight[i]] + value[i] , dp[i-1][j] );
                }
            }
        }

        //打印
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}