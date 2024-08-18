package year1.month1.week1.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class All_Reachable_Paths_C_II {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<LinkedList<Integer>> graph = new ArrayList<>(n+1); //申请n+1长度
        for (int i=1; i<n+1; i++)graph.add(new LinkedList<>());

        for (int i=0; i<m; i++){ //有多少条边加多少次
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            graph.get(l).add(r);
        }

        Solution_arpct solutionArpct = new Solution_arpct();
        solutionArpct.path.add(1);
        solutionArpct.dfs(graph,1,n);

        if (solutionArpct.result.isEmpty())System.out.println(-1);

        for (List<Integer> res : solutionArpct.result){
            for (int i=0; i<res.size()-1; i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println(res.get(res.size()-1));
        }
    }
}

class Solution_arpct{

    //领接表
    //直接用for(int i:LinkedList<Integer>)来遍历每个节点
    //path必须先加1，因为默认从x=1开始，但是没办法加进逻辑里，只能初始化
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void dfs(List<LinkedList<Integer>> graph, int x, int n){
        if (x==n){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph.get(x)){
            path.add(i);
            dfs(graph, i, n);
            path.remove(path.size()-1);
        }
    }
}
