package year1.month1.week1.day4;

public class One_And_Sero_474 {
}

class Solution_474 {
    //转化成背包问题
    //dp[m][n]为包含m个0和n个1的子集的最大长度
    //dp[j][k] = Math.max( dp[j][k] , dp[j-nums[i][0]][k-nums[i][1]] + 1 )
    //自己的思路和别人的思路区别：在遍历字符串时同时遍历物品,直接用zero和one启动两个for循环得到结果
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
//        int len = strs.length;
//        int[][] nums = new int[len][2]; //记录每个字符串的含0数和含1数
//        int index=0;
        for (String str : strs){ //每个str就是每个物品
//            char[] chars = str.toCharArray();
            int zero=0;
            int one=0;
            for (char charM : str.toCharArray()){
                if (charM=='0'){
                    zero++;
                } else if (charM=='1') {
                    one++;
                }
            }
//            nums[index][0]=zero;
//            nums[index++][1]=one;

            for (int j=m; j>=zero; j--){
                for (int k=n; k>=one; k--){
                    dp[j][k] = Math.max( dp[j][k] , dp[j-zero][k-one] + 1 );
                }
            }
        }

//        for (int i=0; i<len; i++){
//            for (int j=m; j>=nums[i][0]; j--){
//                for (int k=n; k>=nums[i][1]; k--){
//                    dp[j][k] = Math.max( dp[j][k] , dp[j-nums[i][0]][k-nums[i][1]] + 1 );
//                }
//            }
//        }
        return dp[m][n];
    }
}