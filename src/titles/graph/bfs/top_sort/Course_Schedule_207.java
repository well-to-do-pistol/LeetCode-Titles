package titles.graph.bfs.top_sort;

import java.util.*;


class Solution_207 {
    // 用数组索引和数组值连成图，观察是否有环
    // 用邻接表连图，创建入度表
    // 拓扑排序
    // 把入度为0的点放队列
    // 一个个遍历，同时--numCourses，对面入度-1，如果为零加队列
    // 判断numCourses是否大于0
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        int[] enters = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int pcourse = pre[1];
            graph.get(pcourse).add(course);
            ++enters[course];
        }
        Deque<Integer> zqueue = new LinkedList<Integer>();
        for (int i=0; i<enters.length; ++i) {
            if (enters[i]==0)
                zqueue.offer(i);
        }

        while(!zqueue.isEmpty()) {
            int pcourse = zqueue.poll();
            --numCourses;
            for (int course : graph.get(pcourse)) {
                if (--enters[course]==0) {
                    zqueue.offer(course);
                }

            }
        }
        return numCourses==0;
    }
}