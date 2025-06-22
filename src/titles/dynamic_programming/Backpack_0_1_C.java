package titles.dynamic_programming;

public class Backpack_0_1_C {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
        oneDimensionalDP(weight,value,bagSize);
    }

    // 先物品后背包，背包倒序
    // dp[j]容量为j时能装的物品最大价值
    // dp[j] = max(dp[j],dp[j-weight[i]]+value[i])
    private static void oneDimensionalDP(int[] weight, int[] value, int bagSize) {
        System.out.println("1. 滚动数组：");
        int n = weight.length;
        int[] dp = new int[bagSize+1];
        for (int i=0; i<n; ++i){
            for (int j=bagSize; j>=weight[i]; --j){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
                System.out.print(dp[j]+" ");
            }
            System.out.println();
        }
    }

    // dp[i][j]  用0到i物品在j容量的情况下的最大价值
    // dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])   不用该物品和用该物品的最大值
    // 第一行必须初始化，因为要从物品1开始避免越界
    // j<weight[i]时，也要计算为dp[i-1][j]，避免出错
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        System.out.println("2. 二维数组：");
        int n = weight.length;
        int[][] dp = new int[n][bagSize+1];
        for (int j=weight[0]; j<=bagSize; ++j)
            dp[0][j] = value[0];
        for (int i=1; i<n; ++i){
            for (int j=0; j<=bagSize; ++j){
                if (j<weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
