package titles.two_pointers;

import java.util.*;

public class Collect_Rainwater_42 {
}


class Solution_42 {

    // 1.动态规划
    // 计算并用数组保存每个索引的两边高度最值
    // 遍历每个索引, 用两边高度最值的较小值-自身高度为面积
    // public int trap(int[] height) {
    //     int len = height.length;
    //     int[] leftMax = new int[len];
    //     int[] rightMax = new int[len];
    //     leftMax[0] = height[0];
    //     rightMax[len-1] = height[len-1];
    //     for(int i=1; i<len; ++i){
    //         leftMax[i]=Math.max(leftMax[i-1],height[i]);
    //     }
    //     for(int j=len-2; j>=0; --j){
    //         rightMax[j]=Math.max(rightMax[j+1],height[j]);
    //     }
    //     int count=0;
    //     for(int i=0; i<len; ++i){
    //         count+=Math.min(leftMax[i],rightMax[i])-height[i];
    //     }
    //     return count;
    // }


    // 2.单调栈(单调递增)
    // 必须用Deque，用Stack慢10ms慢很多
    // 找凹陷来算面积: (1)比栈顶小, 入栈(入的是索引); (2)等于, 跳过(入不入都一样, 入栈面积也会等于0, 因为我们只利用连续3个索引来算面积); (3)大于, 记录mid, 计算h为两边较小值, 宽为索引差-1
    // public int trap(int[] height) {
    //     Deque<Integer> stack = new LinkedList<Integer>();
    //     int count=0, n=height.length;
    //     for(int i=0; i<n; ++i){
    //         while(!stack.isEmpty() && height[i]>height[stack.peek()]){ //注意弹出的是索引
    //             int mid=stack.pop();
    //             if(stack.isEmpty())break;
    //             int l=stack.peek();                       //注意栈里的是左边的边
    //             int h=Math.min(height[i],height[l])-height[mid];
    //             int w=i-l-1;
    //             count+=h*w;
    //         }
    //         stack.push(i);
    //     }
    //     return count;
    // }


    // 3. 双指针法
    // 逻辑和动规差不多, 都是算每个索引两边高度最值, 然后用两边最值的较小值-当前高度=面积
    // 计算两边最值都一样, 然而计算面积过程有点不同, 每次算较短的一边, 然后移动指针向较长一边靠近
    // 比较当前边, 得到较小值, 因为较小的对应的max肯定也比对方小
    public int trap(int[] height) {
        int count=0, leftMax=0, rightMax=0, l=0, r=height.length-1;
        while(l<r){
            leftMax=Math.max(leftMax,height[l]);
            rightMax=Math.max(rightMax,height[r]);
            if(height[l]<height[r]){
                count+=leftMax-height[l];
                ++l;
            }else{
                count+=rightMax-height[r];
                --r;
            }
        }
        return count;
    }
}