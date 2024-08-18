package year1.month1.week1.day5;

import java.util.ArrayDeque;
import java.util.Queue;

public class Number_Of_Islands_200 {
}
class Solution_200 {
    //遍历所有节点，遇到false且陆地，count++, dfs将附近陆地变为true
    //继续遍历
    //dfs遍历四个方向因为斜连接不算
    //终止条件隐藏因为只会在fasle且陆地递归，相当于true和海就终止

    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visited[i][j] && grid[i][j] == '1'){ //不能用""因为这个是字符串
                    visited[i][j]=true;
                    count++;
//                    dfs(grid, visited, i, j);
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
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

                //判断边界,访问和陆地
                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && !visited[visitX][visitY] && grid[visitX][visitY]=='1' ){ //这里是char
                    queue.add(new int[]{visitX, visitY});
                    visited[visitX][visitY]=true;
                }
            }
        }
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        //隐藏终止条件

        //遍历四个方向
        for (int[] dir : direction){
            int visitX = x+dir[0];
            int visitY = y+dir[1];

            //先判断边界
            if (visitX<0 || visitY<0 || visitX>=grid.length || visitY>=grid[0].length){
                continue;
            }

            //在判断false且陆地
            if (!visited[visitX][visitY] && grid[visitX][visitY]=='1'){
                visited[visitX][visitY]=true;
                dfs(grid, visited, visitX, visitY);
            }
        }
    }
}