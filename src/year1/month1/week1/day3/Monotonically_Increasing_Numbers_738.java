package year1.month1.week1.day3;

import java.util.Arrays;

public class Monotonically_Increasing_Numbers_738 {
}
class Solution_738 {
    //整体思路：两两比较，前一位大于后一位，前一位-1，后一位取最大值
    //1.转化成字符串，容易遍历；
    //2.从后往前，不是从前往后两两比较，332变成329;
    //3.建立一个flag记录往后全赋成9的索引，因为不记录的话会导致1000变成900；
    public int monotoneIncreasingDigits(int n) {
        String num = String.valueOf(n);
        char[] charNums = num.toCharArray();
        int len = num.length();
        int flag = len;
        for (int i=len-1; i>0; i--){
            if (charNums[i-1]>charNums[i]){
                charNums[i-1]--;
                flag=i;
            }
        }
        for (int i=flag; i<len; i++){
            charNums[i]='9';
        }
//        return Integer.parseInt(Arrays.toString(charNums)); //会包括方括号和逗号
        return Integer.parseInt(String.valueOf(charNums));
    }
}