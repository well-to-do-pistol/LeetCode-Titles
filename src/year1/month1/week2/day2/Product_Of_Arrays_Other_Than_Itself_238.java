package year1.month1.week2.day2;

public class Product_Of_Arrays_Other_Than_Itself_238 {
    public static void main(String[] args) {
        Solution_238 solution238=new Solution_238();
        solution238.productExceptSelf(new int[]{1,2,3,4,5});
    }
}
class Solution_238 {
    //先计算左边乘积数组
    //用R代表右边数组乘积
    //最后从后往前遍历更新答案数组
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] answer = new int[len];
        answer[0]=1;//因为0左边没有数,所以左边乘积初始化为1
        for (int i=1; i<len; i++){
            answer[i]=answer[i-1]*nums[i-1]; //要乘以i-1
        }
        int R=1; //右边乘积初始化为1
        for (int i=len-1; i>=0; i--){
            answer[i]=answer[i]*R; //左边乘右边
            R*=nums[i];
        }
        return answer;
    }
}