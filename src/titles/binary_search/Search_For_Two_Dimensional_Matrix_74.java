package titles.binary_search;

public class Search_For_Two_Dimensional_Matrix_74 {
}
class Solution_74 {
    //从右上角开始遍历
    //在行上要二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i=0, j=m-1;
        while (i<n && i>=0){
            if (matrix[i][j]==target){
                return true;
            }else if (matrix[i][j]>target){
                if (binarySearch(matrix,i,0,j,target))
                    return true;
                return false;
            }else{
                ++i;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int i, int l, int r, int target){
        while(l<=r){
            int mid = l+((r-l)>>1);
            if (matrix[i][mid]==target){
                return true;
            }else if(matrix[i][mid]>target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}