package titles.dynamic_programming.multidimensional_dynamic_programming;
import java.util.*;
public class Min_Path_Sum_64 {
}
class Solution {
    // 1. 二维dp
    // dp[i][j]为到达该点的最小路径和
    // public int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][] dp = new int[m][n];
    //     dp[0][0] = grid[0][0];
    //     for (int i=1; i<m; ++i)
    //         dp[i][0] = grid[i][0]+dp[i-1][0];
    //     for (int j=1; j<n; ++j)
    //         dp[0][j] = grid[0][j]+dp[0][j-1];
    //     for (int i=1; i<m; ++i){
    //         for (int j=1; j<n; ++j){
    //             dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }

    // 2. 一维dp
    // dp[j] = min(dp[j],dp[j-1])+grid[i-1][j-1];
    //      因为dp[j]还没算出来，所以相当于dp[i-1][j]
    //      dp[j-1]在上一次for循环已经算出来了，所以相当于dp[i][j-1]
    //      因为我们是先遍历i再遍历j
    // i,j必须从1开始，初始化dp[1]为0，grid为i-1和j-1，而且数组要赋上最大值
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[210];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i=1; i<=m; ++i) {
            for (int j=1; j<=n; ++j) {
                dp[j] = Math.min(dp[j],dp[j-1])+grid[i-1][j-1];
            }
        }
        return dp[n];
    }
}