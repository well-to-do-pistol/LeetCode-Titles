package year1.month1.week1.day6;

import java.util.Scanner;

public class The_Circumference_Of_The_Island_C {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] grid = new int[n][m];
        Solution_tcotic solutionTcotic = new Solution_tcotic();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int x=scanner.nextInt();
                grid[i][j]=x;
            }
        }

        int length=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]==1){
                    solutionTcotic.count=0;
                    solutionTcotic.helper(grid,i,j);
                    length+=solutionTcotic.count;
                }
            }
        }

        System.out.println(length);
    }
}

class Solution_tcotic{
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