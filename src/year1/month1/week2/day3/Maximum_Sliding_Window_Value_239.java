package year1.month1.week2.day3;

import java.util.Deque;
import java.util.LinkedList;

public class Maximum_Sliding_Window_Value_239 {
}
class Solution_239 {
    class MyQueue{
        Deque<Integer> myqueue ;
        MyQueue(){
            this.myqueue = new LinkedList<Integer>();
        }
        boolean isEmpty(){
            return myqueue.isEmpty();
        }
        void poll(int num){
            if (!myqueue.isEmpty() && myqueue.peek() == num){
                myqueue.poll();
            }
        }
        void add(int num){
            while (!myqueue.isEmpty() && num > myqueue.getLast()){ //只把大于的移除啊， 不要等于
                myqueue.removeLast();
            }
            myqueue.add(num);
        }
        //            void add(int num){
//                  if (!myqueue.isEmpty() && num >= myqueue.peek()){ //getLast会判空
//                        myqueue.clear();
//                        myqueue.add(num);
//                  }
//
//            }
        int peek(){
            return myqueue.peek();
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        //长度是1直接返回
        int len = nums.length;
        if (len==1)return nums;
        //滑动窗口，先加前k个，然后先poll移除再add加

        int num = 0;
        int[] ans = new int[len-k+1];
        MyQueue myQueue = new MyQueue();
        for (int i=0; i<k; i++){
            myQueue.add(nums[i]);
        }
        ans[num++] = myQueue.peek(); //第一个已赋值，接着从k开始
        for (int i=k; i<len; i++){
            myQueue.poll(nums[i-k]); //poll的时候要记得-k啊, 因为只需要移除滑动窗口的头部
            myQueue.add(nums[i]);  //就是加的时候进行一个剪枝， 前面小的都不用留了
            ans[num++]=myQueue.peek();
        }
        return ans;
    }
}