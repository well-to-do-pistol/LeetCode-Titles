package titles.dynamic_programming.multidimensional_dynamic_programming;

public class Unique_Paths_II_63 {
}
class Solution_63 {
    // 只有当前格不是障碍，才进行计算
    // dp[i][j]为到当前格有多少条路径
    // 初始化第一行和第一列为1
    // dp[i][j] = dp[i-1][j]+dp[i][j-1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        for (int i=0; i<m && obstacleGrid[i][0]==0; ++i)
            dp[i][0]=1;
        for (int j=0; j<n && obstacleGrid[0][j]==0; ++j)
            dp[0][j]=1;
        for (int i=1; i<m; ++i){
            for (int j=1; j<n; ++j){
                if (obstacleGrid[i][j]==0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}