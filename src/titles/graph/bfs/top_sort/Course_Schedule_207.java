package titles.graph.bfs.top_sort;

import java.util.*;


class Solution_207 {
    // 拓扑排序是依赖优先排序，不是按数值排的，无环是充要条件
    // 只要有依赖关系，优先考虑拓扑排序

    // 判断有无环，并查集是无向，这里是有向要用拓扑
    // 如果是2门课程，索引就是0到1
    // 首先构建图（List<List<>>，起点作为索引，终点作为数组里的值）
    // 然后用数组记录入度
    // 遍历数组，将入度为0（就是所有起点加队列）
    // 遍历队列，减去入度，如果入度为0则加进队列并删除总数++
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] enterCounts = new int[numCourses];
        for (int i=0; i<numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int t = pre[0];
            int s = pre[1];
            graph.get(s).add(t);
            ++enterCounts[t];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; ++i) {
            if (enterCounts[i]==0) {
                queue.add(i);
            }
        }
        int deleteCount = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ++deleteCount;
            for (int tmp : graph.get(cur)) {
                if (--enterCounts[tmp]==0) {
                    queue.offer(tmp);
                }
            }
        }
        return deleteCount==numCourses;
    }
}