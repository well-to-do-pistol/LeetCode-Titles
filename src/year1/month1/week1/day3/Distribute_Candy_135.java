package year1.month1.week1.day3;

import java.util.Arrays;

public class Distribute_Candy_135 {
}

class Solution6 {
    //贪心关键：
    //先遍历右边比左边大的情况，再遍历左边比右边大的情况
    //遍历左边比右边大的情况要从右往左遍历：4321才能累加起来，不然所有糖果都是2221
    public int candy(int[] ratings) {
        int result=0;
        int len = ratings.length;
        int[] sum = new int[len];
        Arrays.fill(sum,1);
        for (int i=1; i<len; i++){
            if (ratings[i]>ratings[i-1])sum[i]=sum[i-1]+1;
        }
        for (int i=len-2; i>=0; i--){
            if (ratings[i]>ratings[i+1])sum[i]=Math.max(sum[i],sum[i+1]+1); //两边情况总结起来
        }
        for (int i=0; i<len; i++){
            result+=sum[i];
        }
        return result;
    }
}