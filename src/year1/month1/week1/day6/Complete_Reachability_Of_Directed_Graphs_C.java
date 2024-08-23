package year1.month1.week1.day6;

import java.util.*;

public class Complete_Reachability_Of_Directed_Graphs_C {
    //应该用布尔数组的
    //这里用了集合
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>(n+1);
        for (int i=0; i<n+1; i++)graph.add(new ArrayList<>());
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            graph.get(s).add(t);
        }
//        System.out.println(graph);

        Solution_crodgc solutionCrodgc = new Solution_crodgc();
        int i=solutionCrodgc.completeReach(graph, n, new HashSet<>());
        System.out.println(i);
    }
}
class Solution_crodgc{
    public int completeReach(List<List<Integer>> graph, int n, Set<Integer> set){
//        dfs(1,graph,n,set);
        bfs(1,graph,n,set);
        return set.size()==n ? 1 : -1;
    }

    private void dfs(int i, List<List<Integer>> graph, int n, Set<Integer> set) {
        set.add(i);
        if (set.size()==n)return;
        if (graph.get(i).isEmpty())return;
        for (int j : graph.get(i)){
            if (!set.contains(j)) dfs(j,graph,n,set);
        }
    }
    private void bfs(int i, List<List<Integer>> graph, int n, Set<Integer> set) {
        Queue<List<Integer>> queue=new ArrayDeque<>();
        if (graph.get(i).isEmpty())return;
        queue.add(graph.get(i));
        set.add(i);

        while (!queue.isEmpty()){
            List<Integer> cur = queue.poll();

            for (int index:cur){
                if (!set.contains(index)){
                    queue.add(graph.get(index));
                    set.add(index);
                }
            }
        }
    }
}
