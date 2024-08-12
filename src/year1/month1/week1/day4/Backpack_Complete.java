package year1.month1.week1.day4;

import java.util.Arrays;

public class Backpack_Complete {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
        testWeightBagProblem2(weight,value,bagSize);
    }


    //先遍历物品和先遍历背包都可以
    //遍历背包时要正序遍历
    private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int len = bagSize+1;
        int[] dp = new int[len];
        for (int i=0; i<weight.length; i++){
            for (int j=weight[i]; j<len ; j++){
                dp[j] = Math.max( dp[j] , dp[j-weight[i]] + value[i] );
            }
        }
        System.out.println(Arrays.toString(dp));
    }


    //先遍历背包
    private static void testWeightBagProblem2(int[] weight, int[] value, int bagSize) {
        int len = bagSize+1;
        int[] dp = new int[len];
        for (int j=1; j<len; j++){
            for (int i=0; i<weight.length ; i++){
                if (j>=weight[i]){
                    dp[j] = Math.max( dp[j] , dp[j-weight[i]] + value[i] );
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
