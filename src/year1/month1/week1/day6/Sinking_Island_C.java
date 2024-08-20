package year1.month1.week1.day6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Sinking_Island_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int x=scanner.nextInt();
                grid[i][j]=x;
            }
        }

        Solution_sic solutionSic = new Solution_sic();
        //上下
        for (int j=0; j<m; j++){
//            if (grid[0][j]==1)solutionSic.dfs(grid, 0, j);
//            if (grid[n-1][j]==1)solutionSic.dfs(grid, n-1, j);

            if (grid[0][j]==1)solutionSic.bfs(grid, 0, j);
            if (grid[n-1][j]==1)solutionSic.bfs(grid, n-1, j);
        }
        //左右
        for (int i=0; i<n; i++){
//            if (grid[i][0]==1)solutionSic.dfs(grid, i, 0);
//            if (grid[i][m-1]==1)solutionSic.dfs(grid,i ,m-1);

            if (grid[i][0]==1)solutionSic.bfs(grid, i, 0);
            if (grid[i][m-1]==1)solutionSic.bfs(grid,i ,m-1);
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]==1)grid[i][j]=0;
                if (grid[i][j]==2)grid[i][j]=1;
            }
        }

        //打印
        for (int i=0; i<n; i++){
            for (int j=0; j<m-1; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println(grid[i][m-1]);
        }
    }

}

class Solution_sic{
    //遍历四边, 把靠边的陆地变成2
    //重新遍历全部, 将2变为1, 将1变为0
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void dfs(int[][] grid, int i, int j){
        //隐藏了终止条件
        grid[i][j]=2;
        for (int[] dir : direction){
            int x = i+dir[0];
            int y = j+dir[1];

            if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!=0 && grid[x][y]!=2){
                dfs(grid, x, y);
            }
        }
    }
    public void bfs(int[][] grid, int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        grid[i][j]=2;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x=cur[0];
            int y=cur[1];

            for (int[] dir : direction){
                int visitX=x+dir[0];
                int visitY=y+dir[1];

                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && grid[visitX][visitY]!=0 && grid[visitX][visitY]!=2){
                    grid[visitX][visitY]=2;
                }
            }
        }
    }
}