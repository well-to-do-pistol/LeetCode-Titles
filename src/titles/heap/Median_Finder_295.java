package titles.heap;
import java.util.*;
public class Median_Finder_295 {
}
class MedianFinder {
    // low 存较小一半 (大顶堆)
    // high 存较大一半 (小顶堆)
    // low和high大小要么相等，要么low比high大1
    // 找中位数就根据这两种情况low.peek()或(low.peek()+high.peek())/2.0
    // 非常简单
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    public MedianFinder() {
        low = new PriorityQueue<>((a,b)->(b-a));
        high = new PriorityQueue<>((a,b)->(a-b));
    }

    public void addNum(int num) {
        if (low.isEmpty() || num<=low.peek()){
            low.offer(num);
        }else{
            high.offer(num);
        }

        if (low.size() > high.size()+1){
            high.offer(low.poll());
        }else if (low.size() < high.size()){ //等于不用管
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() == high.size()+1){
            return low.peek();
        }else {
            return (low.peek()+high.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */