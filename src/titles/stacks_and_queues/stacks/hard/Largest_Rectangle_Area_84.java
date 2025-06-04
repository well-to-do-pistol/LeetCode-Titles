package titles.stacks_and_queues.stacks.hard;
import java.util.*;
public class Largest_Rectangle_Area_84 {
}
class Solution_84 {
    // 栈储存索引，for中用while判断大小(跟栈顶比)，小于证明能计算了（弹出的高*索引差-1）
    // for最后push(i)
    // 最后多遍历一次，一开始判断如果i==n则curHeight为0
    // 抽象原理：比栈顶大的都入栈，小的则作为右边界，然后while弹一个索引作为“高度位”，再利用高度位左边一位计算宽，然后*高度位计算面积；一直算，不比栈顶小为止
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<=n; ++i){
            int curHeight = (i==n) ? 0 : heights[i];
            while(!stack.isEmpty() && curHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i-stack.peek()-1;  // 如果栈为空，说明这是最左边的柱子，宽度就是i； stack.peek() 是当前柱子左侧第一个比它小的柱子的索引所以要-1
                max = Math.max(max, height*width);
            }
            stack.push(i);
        }
        return max;
    }
}