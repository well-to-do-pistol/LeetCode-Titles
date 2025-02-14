package titles.linked_list.deque;

import java.util.*;

public class Maximum_Sliding_Window_Value_239 {
}

class Solution_239 {

    // 1. 单调(双端)队列, 直接放索引, 先把尾部小于当前值的全弹出, 再把头部索引出界的全弹出
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length, index=1;
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<k; ++i){
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
                deque.pollLast();
            deque.offerLast(i);
        }
        int[] res = new int[n-k+1];
        res[0]=nums[deque.peekFirst()];
        for(int i=k; i<n; ++i){
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
                deque.pollLast();
            deque.offerLast(i);
            while(deque.peekFirst()<i-k+1)  //  这里因为加了一个元素, 而且它不可能出界, 不判空也行
                deque.pollFirst();
            res[index++]=nums[deque.peekFirst()];
        }
        return res;
    }


    // 2. (较慢)优先队列放数组(数值, 索引), 如果(最大值)头出界了, 则弹出
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(a[0]==b[0] ? b[1]-a[1] : b[0]-a[0]));
    //     for(int i=0; i<k; ++i){
    //         queue.offer(new int[]{nums[i],i});
    //     }
    //     int n=nums.length, index=1;
    //     int[] res = new int[n-k+1];
    //     res[0]=queue.peek()[0];
    //     for(int i=k; i<n; ++i){
    //         queue.offer(new int[]{nums[i],i});     //至少保证队列有一个元素
    //         while(queue.peek()[1]<i-k+1)
    //             queue.poll();
    //         res[index++]=queue.peek()[0];
    //     }
    //     return res;
    // }
}