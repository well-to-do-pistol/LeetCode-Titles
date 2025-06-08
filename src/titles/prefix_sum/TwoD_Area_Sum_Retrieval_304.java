package titles.prefix_sum;

class TwoD_Area_Sum_Retrieval_304 {
}

class NumMatrix {
    // 创建辅助矩阵，保存每行的前缀和(从1开始，p[i+1]=p[i]+n[i])
    // 用最大-中间1-中间2+最小
    // myMatrix[i+1][j+1] = myMatrix[i][j+1]+rowSum;     //以行为准，所以等于减一行加上当前行
    int[][] myMatrix;
    public NumMatrix(int[][] matrix) {
        myMatrix = new int[matrix.length+1][matrix[0].length+1];
        for (int i=0; i<matrix.length; ++i){
            int rowSum = 0;
            for (int j=0; j<matrix[0].length; ++j){
                rowSum +=matrix[i][j];
                myMatrix[i+1][j+1] = myMatrix[i][j+1]+rowSum;     //以行为准，所以等于减一行加上当前行
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return myMatrix[row2+1][col2+1]-myMatrix[row1][col2+1]-myMatrix[row2+1][col1]+myMatrix[row1][col1];
    }
}
