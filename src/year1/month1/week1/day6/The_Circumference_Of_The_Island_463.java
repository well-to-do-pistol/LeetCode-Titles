package year1.month1.week1.day6;

import java.util.ArrayDeque;
import java.util.Queue;

public class The_Circumference_Of_The_Island_463 {
}
class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int length=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]==1){
                    count=0;
                    helper(grid,i,j);
                    length+=count;
                }
            }
        }
        return length;
    }


    int count=0;
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void helper(int[][] grid, int i, int j) {
        for (int[] dir:direction){
            int x=i+dir[0];
            int y=j+dir[1];
            if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0){ //出界或水就+1
                count++;
            }
        }
    }
}