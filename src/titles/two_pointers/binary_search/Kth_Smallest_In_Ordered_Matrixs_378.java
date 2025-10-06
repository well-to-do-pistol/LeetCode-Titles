package titles.two_pointers.binary_search;

public class Kth_Smallest_In_Ordered_Matrixs_378 {
}
class Solution_378 { // 二分加计数
    // 先写出求<=mid的个数的方法
    // 然后left为(0,0)，right为(n-1,n-1)，这个范围内二分
    // 如果count<k，那么res一定大于mid，舍弃左边left=mid+1
    // 否则，res一定小于等于mid，舍弃右边（不包括）right=mid
    // 知道left==right收敛后，就是答案
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length-1][matrix.length-1];
        while (left<right) {
            int mid = left + ((right-left)>>1);
            int count = coutSmallest(matrix,mid);
            if (count<k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 从左下角开始算，如果小，就加整列，++col
    // 否则，--row
    private int coutSmallest(int[][] matrix, int mid) {
        int count = 0, row = matrix.length-1, col = 0;
        while (row>=0 && col<matrix.length) {
            if (matrix[row][col]<=mid) {
                count+=row+1;
                ++col;
            } else {
                --row;
            }
        }
        return count;
    }
}