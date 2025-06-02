package titles.stacks_and_queues.stacks;
import java.util.*;
public class Min_Stack_155 {

}
class MinStack {
    // when push the val, Math.min with the min and val, push the result
    Stack<Integer> nums;
    Stack<Integer> mins;

    public MinStack() {
        nums=new Stack<>();
        mins=new Stack<>();
        mins.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        nums.push(val);
        mins.push(Math.min(mins.peek(),val)); 
    }

    public void pop() {
        nums.pop();
        mins.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}