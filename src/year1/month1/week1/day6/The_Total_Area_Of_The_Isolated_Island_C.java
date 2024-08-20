package year1.month1.week1.day6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class The_Total_Area_Of_The_Isolated_Island_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt() ;
        int m=scanner.nextInt() ;
        int[][] grid = new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int x=scanner.nextInt();
                grid[i][j]=x;
            }
        }

        Solution_ttaotiic solutionTtaotiic = new Solution_ttaotiic();
        //上下
        for (int j=0; j<m; j++){
//            if (grid[0][j]==1)solutionTtaotiic.bfs(grid, 0, j);
//            if (grid[n-1][j]==1)solutionTtaotiic.bfs(grid, n-1, j);

            if (grid[0][j]==1)solutionTtaotiic.dfs(grid, 0, j);
            if (grid[n-1][j]==1)solutionTtaotiic.dfs(grid, n-1, j);
        }
        //左右
        for (int i=0; i<n; i++){
//            if (grid[i][0]==1)solutionTtaotiic.bfs(grid, i, 0);
//            if (grid[i][m-1]==1)solutionTtaotiic.bfs(grid, i, m-1);

            if (grid[i][0]==1)solutionTtaotiic.dfs(grid, i, 0);
            if (grid[i][m-1]==1)solutionTtaotiic.dfs(grid, i, m-1);
        }
        solutionTtaotiic.count=0; //清零
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
//                if (grid[i][j]==1)solutionTtaotiic.bfs(grid,i,j);

                if (grid[i][j]==1)solutionTtaotiic.dfs(grid,i,j);
            }
        }
        System.out.println(solutionTtaotiic.count);
    }
}

class Solution_ttaotiic{
    //思路:从四条边开始找陆地, 然后把这些陆地相邻的点都变成海, 然后重新遍历计算岛的数量(和计算岛的数量一样)
    //这里可以不用boolean[][], 一遍历到马上变成海就相当于visited了
    //先把四边变成海, 再把count变成0, 再遍历
    int count = 0;
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void bfs(int[][] grid, int i, int j){
        grid[i][j]=0;//自己要先变海
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        count++;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x=cur[0];
            int y=cur[1];

            for (int[] dir : direction){
                int visitX = x+dir[0];
                int visitY = y+dir[1];

                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && grid[visitX][visitY]==1){
                    grid[visitX][visitY]=0;
                    queue.add(new int[]{visitX,visitY});
                    count++;
                }
            }
        }
    }

    public void dfs(int[][] grid, int i, int j){
        //隐藏了终止条件
        grid[i][j]=0; //先将当前变为海
        count++;

        for (int[] dir : direction){
            int visitX = i+dir[0];
            int visitY = j+dir[1];

            if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && grid[visitX][visitY]==1){
                grid[visitX][visitY]=0;
                count++;
                dfs(grid, visitX, visitY);
            }
        }
    }
}