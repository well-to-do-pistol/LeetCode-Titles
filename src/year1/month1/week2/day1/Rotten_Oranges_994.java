package year1.month1.week2.day1;

import java.util.ArrayDeque;
import java.util.Queue;

public class Rotten_Oranges_994 {
    public static void main(String[] args) {
        Solution_994 solution994 = new Solution_994();
        solution994.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }
}
class Solution_994 {
    //多源广度
    //一开始将所有2加入队列
    //为什么最后-1; 因为最后一轮所有橘子1还是会被加进队列还是得遍历
    //只计算新鲜橘子
    int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int minutePassed =0; //最终结果
        int freshCount=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if (grid[i][j]==1)freshCount++;
            }
        }
        if (freshCount==0)return 0;//没有新鲜橘子马上返回0

        while (!queue.isEmpty()){
            int queueSize=queue.size();
            minutePassed++; //每一轮

            while (queueSize-- >0){
                int[] cur=queue.poll();
                int x=cur[0];
                int y=cur[1];
                for (int[] dir:direction){
                    int visitX=x+dir[0];
                    int visitY=y+dir[1];

                    if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && grid[visitX][visitY]==1) { //只找1就行了
                        grid[visitX][visitY]=2;
                        freshCount--;
                        queue.add(new int[]{visitX,visitY});
                    }
                }
            }
        }
        return freshCount==0 ? minutePassed-1 : -1;
    }
}