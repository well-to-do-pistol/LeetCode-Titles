package titles.array.matrix;

import java.util.*;

public class Set_The_Matrix_To_Zero_73 {
}

class Solution_73 {
    // 1. 最佳写法
    // 用第一行和第一列记录是否需要赋0
     public void setZeroes(int[][] matrix) {
         int rowZ = 0, colZ = 0, n=matrix.length, m=matrix[0].length;
         for(int i=0; i<n; ++i){
             if(matrix[i][0]==0){
                 colZ=1;
                 break;
             }
         }
         for(int j=0; j<m; ++j){
             if(matrix[0][j]==0){
                 rowZ=1;
                 break;
             }
         }
         for(int i=1; i<n; ++i){
             for(int j=1; j<m; ++j){
                 if(matrix[i][j]==0){
                     matrix[i][0]=0;
                     matrix[0][j]=0;
                 }
             }
         }
         for(int i=1; i<n; ++i){
             if(matrix[i][0]==0){
                 Arrays.fill(matrix[i],0);
             }
         }
         for(int j=1; j<m; ++j){
             if(matrix[0][j]==0){
                 for(int i=1; i<n; ++i)
                     matrix[i][j]=0;
             }
         }
         if(rowZ==1)Arrays.fill(matrix[0],0);
         if(colZ==1){
             for(int i=0; i<n; ++i)
                 matrix[i][0]=0;
         }
     }


    // 2. 用第一行和第一列记录是否需要赋0
    // 第一次二维遍历: 给colZ赋值, j从1开始, 开始记录
    // 第二次二维遍历(行从后往前防止被影响): 只要matrix[i][0]或matrix[0][j]有零, 则当前置零, 最后根据变量置第一列的零
    // 因为第一次遍历如果第一列有0会直接将matrix[0][0]变为0, 所以无须记录rowZ
//    public void setZeroes(int[][] matrix) {
//        int n=matrix.length, m=matrix[0].length;
//        boolean colZ = false;
//        for(int i=0; i<n; ++i){
//            if(matrix[i][0]==0)colZ=true;                  //这句话要单独放在for循环外面
//            for(int j=1; j<m; ++j){
//                if(matrix[i][j]==0)
//                    matrix[i][0]=matrix[0][j]=0;
//            }
//        }
//        for(int i=n-1; i>=0; --i){
//            for(int j=1; j<m; ++j){
//                if(matrix[i][0]==0 || matrix[0][j]==0)
//                    matrix[i][j]=0;
//            }
//            if(colZ)matrix[i][0]=0;                        //最后才置第一列的零
//        }
//    }
}
