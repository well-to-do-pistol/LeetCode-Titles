package year1.month1.week1.day7;

import java.util.*;

public class Topology_Software_Building_C {
    //将入度为0的点加入队列
    //遍历队列, 将节点指向的点入度-1(移去节点), 将入度为0的点加入队列

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        for (int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            graph.get(s).add(t);
            degree[t]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (degree[i]==0)queue.add(i);
        }

        while (!queue.isEmpty()){
            int cur=queue.poll();
            res.add(cur);
            for (int file : graph.get(cur)){
                degree[file]--;
                if (degree[file]==0)queue.add(file); //加file不是加degree
            }
        }

        if (res.size()==n){
            for (int i=0; i<n; i++){
                System.out.print(res.get(i));
                if (i<n-1) System.out.print(" ");
            }
        }else {
            System.out.println(-1);
        }
        scanner.close();
    }
}
