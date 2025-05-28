package titles.graph.dfs.variants_normal;

public class Number_Of_Islands_200 {
}
class Solution_200 {
    // 深度遍历内存连续,且递归栈的开销比队列开销小
    int m,n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if (grid[i][j]=='1'){
                    ++count;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i-1,j);
    }


    // 广度遍历将所有岛屿变0
    // public int numIslands(char[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int count = 0;
    //     for(int i=0; i<m; ++i){
    //         for(int j=0; j<n; ++j){
    //             if (grid[i][j]=='1'){
    //                 ++count;
    //                 bfs(grid,i,j);
    //             }
    //         }
    //     }
    //     return count;
    // }

    // final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    // private void bfs(char[][] grid,int i,int j){
    //     Queue<int[]> queue = new LinkedList<>();
    //     queue.offer(new int[]{i,j});

    //     while(queue.size()!=0){
    //         int[] cur = queue.poll();
    //         for(int[] d:dir){
    //             int newR = cur[0]+d[0];
    //             int newC = cur[1]+d[1];
    //             if(newR>=0 && newC>=0 && newR<grid.length && newC<grid[0].length && grid[newR][newC]=='1'){
    //                 queue.offer(new int[]{newR,newC});
    //                 grid[newR][newC]='0';
    //             }
    //         }
    //     }
    // }
}