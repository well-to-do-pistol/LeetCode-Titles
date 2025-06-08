package titles.stacks_and_queues.stacks.monotonic_stack;
import java.util.*;
public class Daily_Temperatures_739 {
}
class Solution_739 {
    // 在for里用一个while来判断大小（与栈头判断），大则弹栈（得到的s索引位置有结果了）
    // while完之后，就push(i)等待比它大的数
    // 最终走完，数组里没结果的就是默认值0
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<n; ++i){
            int t = temperatures[i];
            while (!stack.isEmpty() && t > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i-index;
            }
            stack.push(i);
        }
        return res;
    }
}
