package year1.month1.week1.day6;

import java.util.ArrayDeque;
import java.util.Queue;

public class Maximum_Area_Of_Island_695 {
}
class Solution_695 {
    int dfsA=0;
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        boolean[][] visited = new boolean[n][m];
//        for (int i=0; i<n; i++){
//            for (int j=0; j<m; j++){
//                if (!visited[i][j] && grid[i][j]==1){
//                    visited[i][j]=true;
//                    int area = bfs(grid, visited, i, j, 1);
//                    max=Math.max(max,area);
//                }
//            }
//        }
//        return max;

        //dfs
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visited[i][j] && grid[i][j]==1){
                    visited[i][j]=true;
                    dfsA++;
                    dfs(grid, visited, i, j);
                    max=Math.max(dfsA,max);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        //隐藏终止条件了
        for (int[] dir : direction){ //直接从当前节点四个方向遍历
            int visitX = i+dir[0];
            int visitY = j+dir[1];

            if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && !visited[visitX][visitY] && grid[visitX][visitY]==1){
                visited[visitX][visitY]=true;
                dfsA++;
                dfs(grid, visited, visitX, visitY);
            }
        }
    }

    private int bfs(int[][] grid, boolean[][] visited, int i, int j, int area) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : direction){
                int visitX = x+dir[0];
                int visitY = y+dir[1];

                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && !visited[visitX][visitY] && grid[visitX][visitY]==1){
                    queue.add( new int[]{visitX, visitY});
                    visited[visitX][visitY]=true;
                    area++;
                }
            }
        }
        return area;
    }
}