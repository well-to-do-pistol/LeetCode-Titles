package year1.month1.week1.day5;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS_C {

}
class Solution_bfsc{
    //用队列记录遍历过的节点
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void bfs(char[][] grid, boolean[][] visited, int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            for (int[] dir : direction){
                int visitX=curX+dir[0];
                int visitY=curY+dir[1];

                //判断边界和访问
                if (visitX<0 || visitX>= grid.length || visitY<0 || visitY>=grid[0].length)continue;
                if (!visited[visitX][visitY]){
                    queue.add(new int[]{visitX,visitY});
                    visited[visitX][visitY]=true;
                }
            }
        }
    }
}
