package year1.month1.week1.day6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Maximum_Area_Of_Island_C {
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

        int max=0;
        boolean[][] visited = new boolean[n][m];
        Solution_maofic solutionMaofic = new Solution_maofic();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visited[i][j] && grid[i][j]==1){
                    int area = solutionMaofic.bfs(grid, visited, i, j, 1);
                    max=Math.max(max, area);
                }
            }
        }
        System.out.println(max);
    }
}

class Solution_maofic{
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int bfs(int[][] grid, boolean[][] visited, int i, int j, int area){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        visited[i][j]=true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : direction){
                int visitX = x+dir[0];
                int visitY = y+dir[1];

                //判断边界,陆地和访问
                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && !visited[visitX][visitY] && grid[visitX][visitY]==1){
                    queue.add(new int[]{visitX, visitY}); //总是忘记加队列
                    visited[visitX][visitY]=true;
                    area++;
                }
            }
        }
        return area;
    }
}
