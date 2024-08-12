package year1.month1.week1.day2;

public class Gas_Station_134 {
}

class Solution10 {
    //贪心算法：局部最优推出全局最优
    //从0开始，把所有利润相加（同时做两次：1.一次用来查看是否负数，负数则更新start为i+1（贪心思路）；2.一次用来计算总和，总和小于0则返回-1）
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i=0; i<gas.length; i++){
            currentSum+=gas[i]-cost[i];
            totalSum+=gas[i]-cost[i];
            if (currentSum<0){
                start=i+1;//更新索引
                currentSum=0;
            }
        }
        if (totalSum<0)return -1;
        return start;
    }
}