package year1.month1.week2.day1;

public class The_Container_That_Holds_The_Most_Water_11 {
    public static void main(String[] args) {
        Solution_11 solution11 = new Solution_11();
        solution11.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
class Solution_11 {
    //双指针遍历,计算max,跳过较矮的线
    //只要边小于等于最短线,left就一直++,right就一直--
    //最大已经保留,那就直接++--
    //2*4<3*3(数学原理吧)
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while (left<right){
            int shorter=Math.min(height[left],height[right]);
            max=Math.max(max,(right-left)* shorter);
            while (height[left]<=shorter && left<right)left++;
            while (height[right]<=shorter && left<right)right--;
//            System.out.println(max);
        }
        return max;
    }
}