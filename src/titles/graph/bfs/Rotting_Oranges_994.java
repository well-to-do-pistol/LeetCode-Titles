package titles.graph.bfs;
import java.util.*;
public class Rotting_Oranges_994 {
}
class Solution_994 {
    // 将所有2放队列,根据队列每轮的size来广度遍历
    // 最后腐烂完还是有2被放进队列,然后再遍历一次,所以最后总数-1
    // 计算新鲜橘子个数,遍历的时候要减,如果最后还有就返回-1
    int m,n;
    final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int fresh = 0;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    ++fresh;
                }
            }
        }
        if(fresh==0)return 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ++res;
            while(size-->0){
                int[] cur = queue.poll();
                for(int[] d:dir){
                    int newR = cur[0]+d[0];
                    int newC = cur[1]+d[1];
                    if(newR>=0 && newR<m && newC>=0 && newC<n && grid[newR][newC]==1){
                        queue.offer(new int[]{newR,newC});
                        grid[newR][newC]=2;
                        --fresh;
                    }
                }
            }
        }
        return fresh!=0 ? -1 : res-1;
    }
}