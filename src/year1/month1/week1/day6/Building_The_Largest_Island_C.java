package year1.month1.week1.day6;

import java.util.*;

public class Building_The_Largest_Island_C {
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

        Solution_btlic solutionBtlic = new Solution_btlic();
        HashMap<Integer, Integer> num_size = new HashMap<>();
        HashSet<Integer> num=new HashSet<>();
        int max=0;
        boolean haveZ=false;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++){ //标记编号, 计算面积(从2开始)
            for (int j=0; j<m; j++){
                if (grid[i][j]==0)haveZ=true;
                if (grid[i][j]==1 && !visited[i][j]){
                    solutionBtlic.count=0;
//                    solutionBtlic.dfs(grid, visited, i, j);
                    solutionBtlic.bfs(grid, visited, i, j);
                    num_size.put(solutionBtlic.mark, solutionBtlic.count);
                    solutionBtlic.mark++;
                }
            }
        }

        //遍历所有0
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]==0){
                    num.clear(); //先清空集合
                    int res=1; //先加上1, 同时要重置max
                    for (int[] dir: solutionBtlic.direction){
                        int x=i+dir[0];
                        int y=j+dir[1];
                        //判断边界
                        if (x<0 || x>=n || y<0 || y>=m)continue;
                        int index = grid[x][y]; //注意先判断边界再拿编号
                        //哈希表包含键和值, 集合里不包含
                        if (num_size.containsKey(index) && num_size.get(index)!=null && !num.contains(index)){
                            num.add(index);
                            res+=num_size.get(index); //加上面积
                        }
                        max=Math.max(max,res);
                    }
                }
            }
        }

        System.out.println(!haveZ ? n*m : max); //打印max啊吊毛
    }
}
class  Solution_btlic{
    //首先标记所有岛, 用hashmap收集编号和面积
    //然后遍历所有0, 然后从该0的四个方向遍历陆地, 面积相加得到结果
    //取最大值
    int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int count=0;
    int mark=2;
    public void dfs(int[][] grid, boolean[][] visited,int i, int j){
        //隐藏终止条件
        count++;
        visited[i][j]=true;
        grid[i][j]=mark;

        for (int[] dir:direction){
            int x=i+dir[0];
            int y=j+dir[1];

            if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && !visited[x][y] && grid[x][y]==1){
                dfs(grid, visited, x, y);//fuck
            }
        }
    }

    public void bfs(int[][] grid, boolean[][] visited,int i, int j){
        count++;
        visited[i][j]=true;
        grid[i][j]=mark;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{i,j});

        while (!queue.isEmpty()){
            int[] cur=queue.poll();
            int x=cur[0];
            int y=cur[1];

            for (int[] dir:direction){
                int visitX=x+dir[0];
                int visitY=y+dir[1];
                if (visitX>=0 && visitX<grid.length && visitY>=0 && visitY<grid[0].length && !visited[visitX][visitY] && grid[visitX][visitY]==1){
                    count++;//count忘加加,要算面积的
                    queue.add(new int[]{visitX,visitY});
                    visited[visitX][visitY]=true;
                    grid[visitX][visitY]=mark;
                }
            }
        }
    }
}