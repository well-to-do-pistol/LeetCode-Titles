package titles.stacks_and_queues.stacks.monotonic_stack.hard;
import java.util.*;
public class Min_Sub_Array_Len_862 {
}
class Solution_862 {
    // 计算前缀和(long)，算i+1的前缀和，最后遍历从索引0开始
    // for中加两while，一个找结果数组，一个扔掉队列里前缀和比当前大的数
    // 找从队列头找，删从队列尾删，因为：2，-1，2 （3）。res为3，由索引3-peekFirst得到（结果需要队列头，不能从队列头删）
    // 前缀和0,2,1,3
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n+1];
        for (int i=0; i<n; ++i){
            preSum[i+1] = preSum[i]+nums[i];
        }
        int res = n+1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<=n; ++i){
            long curPreSum = preSum[i];
            while (!queue.isEmpty() && curPreSum-preSum[queue.peekFirst()] >= k){
                res = Math.min(res,i-queue.pollFirst());
            }
            while (!queue.isEmpty() && preSum[queue.peekLast()] >= curPreSum){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res >= n+1 ? -1 : res;
    }
}
