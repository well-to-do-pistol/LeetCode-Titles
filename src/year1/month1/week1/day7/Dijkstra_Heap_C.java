package year1.month1.week1.day7;

import java.util.*;

class Edge{
    int to;
    int val;
    public Edge(int to, int val){
        this.to=to;
        this.val=val;
    }
}
class Pair<U,V>{
    public U point; //节点
    public V val;   //节点到源点的权值
    public Pair(U point, V val){
        this.point=point;
        this.val=val;
    }
}
class ComparisonM implements Comparator<Pair<Integer,Integer>>{

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o1.val-o2.val;
    }
}
public class Dijkstra_Heap_C {
    //这里适用于稀疏图
    //比较必须建一个元素抽象为T的类才能用于优先队列排序, 用map不行因为map是集合不是单个条目
    //用优先队列放<节点,权值>, 每次弹出最小的那个
    //图用邻接表存储

    public static void main(String[] args) { //O (V+E)log V ->时间复杂度
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            int val=scanner.nextInt();
            graph.get(s).add(new Edge(t,val));
        }

        boolean[] visited = new boolean[n+1];
        int[] minList = new int[n+1];
        Arrays.fill(minList,Integer.MAX_VALUE);
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new ComparisonM());

        pq.add(new Pair<>(1,0)); //初始化
        minList[1]=0; //不要忘了

        int[] edges= new int[n+1];
        while (!pq.isEmpty()){ //遍历所有边
            //1.找最近节点, 一句搞定
            Pair<Integer, Integer> pair = pq.poll();

            //2.标记
            visited[pair.point]=true;

            //3.更新最短距离
            for (Edge e:graph.get(pair.point)){ //遍历与当前节点对接的所有节点
                if (!visited[e.to] && minList[pair.point]+e.val<minList[e.to] ){ //拿当前值的最小+边比较
                    minList[e.to]=minList[pair.point]+e.val;
                    pq.add(new Pair<>(e.to,e.val));

                    edges[e.to]=pair.point; //2-1防止被覆盖
                }
            }
            System.out.println(Arrays.toString(minList));
        }

        if (minList[n]!=Integer.MAX_VALUE){
            System.out.println(minList[n]);
        }else {
            System.out.println(-1);
        }

        for (int i=1; i<=n; i++){
            System.out.println(edges[i]+"->"+i);//得倒着遍历
        }
        scanner.close();
    }
}
