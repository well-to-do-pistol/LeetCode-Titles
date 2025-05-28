package titles.array.matrix;

import java.util.*;

public class Rotate_Images_48 {
}

class Solution_48 {

    // a[i][j] = a[j][n-1-i];             第一行转移到最后一列
    // a[j][n-1-i] = a[n-1-i][n-1-j];     最后一列转移到最后一行
    // a[n-1-i][n-1-j] = a[n-1-j][i];     最后一行转移到第一列
    // a[n-1-j][i] = a[i][j];             第一列转移到第一行
    // 等式索引规律: 交换索引然后n-1-第二个索引值
    // 最后更新映射关系即为转移关系的颠倒
    // 只需遍历左上角(奇数需要少遍历一行)
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int col = (n+1)/2-1;
        int row = n/2-1;
        for(int i=0; i<=row; ++i){
            for(int j=0; j<=col; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}

