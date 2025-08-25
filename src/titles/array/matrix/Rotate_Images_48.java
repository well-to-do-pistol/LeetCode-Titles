package titles.array.matrix;

import java.util.*;

public class Rotate_Images_48 {
}

class Solution_48 {
    // 第一行第一列变成第一行第三列
    // 第一行第二列变成第二行第三列，证明先交换行拿列原值，列拿n-1去减原行值
    // a[i][j] -> a[j][n-i-1]
    // a[j][n-i-1] -> a[n-i-1][n-j-1]
    // a[n-i-1][n-j-1] -> a[n-j-1][i]
    // a[n-j-1][i] -> a[i][j]
    // 只需遍历左上角，奇数少遍历一行（列是n/2+1），所以9宫格只需遍历1，2
    // (n+1)/2，就不用%2来判断啦
    // 注意倒着来
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int col = (n+1)/2;
        int row = n/2;
        for (int i=0; i<row; ++i) {
            for (int j=0; j<col; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}

