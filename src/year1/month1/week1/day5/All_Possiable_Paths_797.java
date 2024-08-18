package year1.month1.week1.day5;

import java.util.ArrayList;
import java.util.List;

public class All_Possiable_Paths_797 {
}
class Solution_797 {

    //邻接表
    //注意遍历节点(从0开始不是从1索引开始)
    //为什么遍历到x==n就等于路径呢? 因为x==n就相当于到了终点：例如：1直接到了5
    //要遍历的是数组里节点的数，不是索引(path加的什么遍历什么)
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);  //节点从0开始，先加0
        dfs(graph,0,graph.length-1);
        return result;
    }

    private void dfs(int[][] graph, int x, int n) {
        if (x==n){
            result.add(new ArrayList<>(path));
            return;
        }

        int[] temp = graph[x]; //遍历当前节点连接的所有节点
        for (int i=0; i<temp.length; i++){
            path.add(temp[i]);
            dfs(graph,temp[i],n);
            path.remove(path.size()-1);
        }
    }
}