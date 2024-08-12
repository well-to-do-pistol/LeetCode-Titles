package year1.month1.week1.day3;

import java.util.Stack;

public class Lemon_Water_Change_860 {
}

class Solution4 {
    //贪心策略：20的时候优先选择5+10来找零，否则用5+5+5
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0,twenty=0;
        for (int i:bills){
            if (i==5){
                five++;
                continue;
            }//continue不要和别的放同一行
            if (i==10){
                if (five==0){
                    return false;
                }
                else{
                    five--;
                    ten++;
                }
            }
            if (i==20){
                if (five>0 && ten>0){
                    five--;
                    ten--;
                    twenty++;
                }else if (five>=3){
                    five-=3;
                    twenty++;
                }else return false;
            }
        }
        return true;
    }
}