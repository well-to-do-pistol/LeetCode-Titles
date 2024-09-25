package year1.month1.week2.day2;

public class Set_The_Matrix_To_Zero_73 {
}
class Solution_73 {
    //用一个变量记录第一列是否要置零
    //用第一行和第一列记录该行或该列是否需要置零
    //倒序遍历, 防止置的零影响
    public void setZeroes(int[][] matrix) {
        int m=matrix.length; //行
        int n=matrix[0].length; //列
        boolean isColumn0=false;
        for (int i=0; i<m; i++){
            if (matrix[i][0]==0)isColumn0=true;

            for (int j=1; j<n; j++){
                if (matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
        for (int i=m-1; i>=0; i--){
            for (int j=1; j<n; j++){
                if (matrix[i][0]==0 || matrix[0][j]==0)matrix[i][j]=0;
            }

            if (isColumn0)matrix[i][0]=0;
        }
    }
}

