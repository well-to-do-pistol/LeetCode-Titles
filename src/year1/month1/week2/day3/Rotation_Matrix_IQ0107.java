package year1.month1.week2.day3;

public class Rotation_Matrix_IQ0107 {
}
class Solution_IQ0107 {
    //处理奇数情况
    //nums[row][col]=nums[col][n-row-1] //第i行j列变成倒数第i列j行

    //nums[j][n-i-1]
    //nums[n-i-1][n-j-1]
    //nums[n-j-1][i]
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0; i<n/2; i++){
            for (int j=0; j<(n+1)/2; j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }
}