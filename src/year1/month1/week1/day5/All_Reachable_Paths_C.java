package year1.month1.week1.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class All_Reachable_Paths_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n+1][n+1]; //多少节点生成多大矩阵
        for (int i=1; i<=m; i++){ //多少条边加进graph里
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            graph[l][r]=1;
        }

        Solution_arpc solutionArpc = new Solution_arpc();
        solutionArpc.path.add(1);
        solutionArpc.dfs(graph, 1, n);

        for (List<Integer> res : solutionArpc.result){
            for (int i=0; i<res.size()-1; i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println(res.get(res.size()-1)); //最后一个单独打印
        }
    }
}

class Solution_arpc{
    //矩阵
    //graph来装图
    //每个path必须起点设置为1
    //因为只能默认最开始的x是1，但是不能包含，所以只能先初始化
    //通过找出矩阵值为1的x和i, 将i加进路径，进行递归
    //每层递归都要遍历一遍剩下的节点

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void dfs (int[][] graph, int x, int n){
        if (x==n){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=1; i<=n; i++){ //从1开始遍历到最后一个节点
            if (graph[x][i]==1){
                path.add(i);
                dfs(graph, i, n);
                path.remove(path.size()-1);
            }
        }
    }
}
