package year1.month1.week1.day6;

import java.util.*;

public class Water_Flow_Issue_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] grid=new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int x=scanner.nextInt();
                grid[i][j]=x;
            }
        }

        Solution_wfic solutionWfic = new Solution_wfic();
        boolean[][] first=new boolean[n][m];
        boolean[][] second=new boolean[n][m];
        //上下
        for (int j=0; j<m; j++){
//            solutionWfic.dfs(grid, first, 0, j, grid[0][j]);
//            solutionWfic.dfs(grid, second, n-1, j, grid[n-1][j]);

            solutionWfic.bfs(grid, first, 0, j);
            solutionWfic.bfs(grid, second, n-1, j);
        }
        //左右
        for (int i=0; i<n; i++){
//            solutionWfic.dfs(grid, first, i, 0, grid[i][0]);
//            solutionWfic.dfs(grid, second, i, m-1, grid[i][m-1]);

            solutionWfic.bfs(grid, first, i, 0);
            solutionWfic.bfs(grid, second, i, m-1);
        }
        //再遍历全部
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (first[i][j] && second[i][j])solutionWfic.res.add(new int[]{i,j});
            }
        }

        for (int[] nums : solutionWfic.res){
                System.out.println(nums[0]+" "+nums[1]);
        }
    }
}
class  Solution_wfic{
    //遍历过的地方就不用遍历了
    //从上下左右两边开始遍历, 逆流而上, 交汇(两个数组都是true)就是所求点
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    List<int[]> res = new ArrayList<>();
    public void dfs(int[][] grid, boolean[][] visited,int i, int j, int preH){

        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]<preH || visited[i][j])return;

        visited[i][j]=true;

        for (int[] dir : direction){
            int x=i+dir[0];
            int y=j+dir[1];

            dfs(grid, visited, x, y, grid[i][j]); //前面的高度是ij
        }
    }

    public void bfs(int[][] grid, boolean[][] visited,int i, int j){
        if (visited[i][j])return;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{i,j});
        visited[i][j]=true; //忘了加true

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x=cur[0];
            int y=cur[1];

            for (int[] dir:direction){
                int visitX=x+dir[0];
                int visitY=y+dir[1];
                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && !visited[visitX][visitY] && grid[visitX][visitY]>=grid[x][y]){
                    queue.add(new int[]{visitX,visitY});
                    visited[visitX][visitY]=true;
                }
            }
        }
    }
}