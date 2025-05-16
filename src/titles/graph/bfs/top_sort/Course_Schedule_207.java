import java.util.*;


class Solution_207 {
    // 拓扑排序是依赖优先排序，不是按数值排的，无环是充要条件
    // 只要有依赖关系，优先考虑拓扑排序
    // 1. 找出所有入度为0的点
    // 2. 遍历入度为0的点，所有其终端点的入度--，如果入度变0,再加入队列
    // 3. 最后计算减去的所有点是否等于图中所有点，证明无环与否
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i=0; i<numCourses; ++i){
            graph.add(new ArrayList<>());
        }
        for (int[] prere : prerequisites){
            int s = prere[1];        // s是第二个， t是第一个
            int t = prere[0];
            graph.get(s).add(t);
            ++degree[t];
        }
        for (int i=0; i<numCourses; ++i){
            if (degree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            ++count;
            for(int i : graph.get(cur)){
                if (--degree[i] == 0){
                    queue.add(i);  // 加入i不是cur
                }
            }
        }
        return count == numCourses;
    }
}