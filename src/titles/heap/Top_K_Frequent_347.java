package titles.heap;
import java.util.*;
public class Top_K_Frequent_347 {
}
class Solution_347 {
    // 所有东西放map
    // PriorityQueue<int[]>小根堆
    // entrySet()遍历map放小根堆，大小超出k就弹出头部最小的，插进当前的
    // 遍历k次小根堆放结果数组
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size()==k){
                if (queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else{
                queue.offer(new int[]{num,count});
            }
        }
        for (int i=0; i<k; ++i){
            res[i] = queue.poll()[0];
        }
        return res;
    }
}