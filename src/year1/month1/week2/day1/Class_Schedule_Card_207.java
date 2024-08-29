package year1.month1.week2.day1;

import java.util.*;

public class Class_Schedule_Card_207 {
}


class Solution_207 {
    //只要有依赖关系, 优先考虑拓扑排序
    //1.找出入度为0的点开始
    //2.删除点,更新入度,将入度为0的点加入队列
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i=0; i<numCourses; i++)graph.add(new ArrayList<>());
        for (int[] pre:prerequisites){
            int s=pre[1];
            int t=pre[0];
            graph.get(s).add(t);
            degree[t]++; //初始化是0,可以++
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<numCourses; i++){
            if (degree[i]==0){
                queue.add(i);
            }
        }

        int count=0;
        while (!queue.isEmpty()){
            int cur=queue.poll();
            count++;
            for (int t : graph.get(cur)){ //cur点指向的点
                degree[t]--;
                if (degree[t]==0)queue.add(t);
            }
        }
        return count==numCourses;
    }
}