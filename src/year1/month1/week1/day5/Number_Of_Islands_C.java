package year1.month1.week1.day5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Number_Of_Islands_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] grid = new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int x = scanner.nextInt();
                grid[i][j]=x;
            }
        }

        //DFS
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        Solution_noic solutionNoic = new Solution_noic();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visited[i][j] && grid[i][j]==1){
                    visited[i][j]=true;
                    count++;
                    solutionNoic.dfs(grid, visited, i, j);
                }
            }
        }
        System.out.println(count);

        //BFS
        int count2 = 0;
        boolean[][] visited2 = new boolean[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visited2[i][j] && grid[i][j]==1){
                    visited2[i][j]=true;
                    count2++; //dfs和bfs都一样, 都是先找到一个false的陆地, count++之后再用dfs或bfs把周围岛屿变true
                    solutionNoic.bfs(grid, visited2, i, j);
                }
            }
        }
        System.out.println(count2);
    }
}

class Solution_noic{
    //两层for循环遍历矩阵每一个节点
    //每遍历到一个false的岛，count++,进行dfs(将所有邻近陆地变true)

    //dfs将所有邻近陆地变true，遍历4个方向，一旦是false的陆地则变为true，继续递归直到遇到true或海
    //因为斜连接不算，所以只有四个方向
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void dfs(int[][] grid, boolean[][] visited, int x, int y){
        //隐含了终止条件（只有遍历到了false而且是岛才会进行dfs），相当于遍历到了true和海就终止

        for (int[] dir : direction){
            int visitX = x+dir[0];
            int visitY = y+dir[1];

            //先处理边界
            if (visitX<0 || visitX>= grid.length || visitY<0 || visitY>=grid[0].length){ //x不能超过行数-1，y不能超过列数-1
                continue;
            }

            //false而且陆地
            if (!visited[visitX][visitY] && grid[visitX][visitY]==1){
                visited[visitX][visitY]=true;
                dfs(grid, visited, visitX, visitY);
            }
        }
    }


    public void bfs(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>(); //bfs要用队列装,先装一个
        queue.add(new int[]{i,j});
        visited[i][j]=true;

        while (!queue.isEmpty()){
            //对每一个节点进行4个方向的遍历
            int[] cur = queue.poll(); //弹出当前节点
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : direction){
                int visitX = x + dir[0];
                int visitY = y + dir[1];

                //判断边界和访问和陆地
                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && !visited[visitX][visitY] && grid[visitX][visitY]==1){
                    visited[visitX][visitY]=true;
                    queue.add(new int[]{visitX,visitY}); //先判断再添加不是乱添加
                }
            }
        }
    }
}
