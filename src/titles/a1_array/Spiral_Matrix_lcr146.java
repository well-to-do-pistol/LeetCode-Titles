package titles.a1_array;

public class Spiral_Matrix_lcr146 {
}
//利用left,right,top,bottom相互牵制, 在while里循环
class Solution_lcr146 {
    private int left,right,top,bottom;
    public int[] spiralArray(int[][] array) {
        if(array==null||array.length==0)return new int[0];
        int n=array.length,m=array[0].length;
        bottom=n-1;
        right=m-1;
        int[] res = new int[n*m];
        int ptr=0;
        while(left<=right && top<=bottom){
            ptr=a(array,ptr,res);
        }
        return res;
    }
    private int a(int[][] array, int ptr, int[] res){
        for(int j=left; j<=right; j++){
            res[ptr++]=array[top][j];
        }
        top++;
        for(int i=top; i<=bottom; i++){
            res[ptr++]=array[i][right];
        }
        right--;
        if(left>right||top>bottom)return ptr;
        for(int j=right; j>=left; j--){
            res[ptr++]=array[bottom][j];
        }
        bottom--;
        for(int i=bottom; i>=top; i--){
            res[ptr++]=array[i][left];
        }
        left++;
        return ptr;
    }
}