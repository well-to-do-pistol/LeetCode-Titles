package year1.month1.week2.day2;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {
    public static void main(String[] args) {
        System.out.println(3/2);
    }
}
class Solution_54 {
    //判断只有一行或一列的情况
    //确定sR,dR,sC,dC
    //遍历的时候一定要选择当前圈的sR,dR,sC,dC,不然会出bug
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>res=new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0)return res;
        int sR=0;
        int sC=0;
        int dR=matrix.length-1;
        int dC=matrix[0].length-1;

        while (sR<=dR && sC<=dC){
            if (sR==dR){ //只有一行
                for (int cur=sC; cur<=dC; cur++)res.add(matrix[sR][cur]);
            } else if (sC==dC) {
                for (int cur=sR; cur<=dR; cur++)res.add(matrix[cur][sC]);
            }else {
                int curR=sR;
                int curC=sC;
                while (curC!=dC){ //当前圈顶行
                    res.add(matrix[sR][curC]);
                    curC++;
                }
                while (curR!=dR){ //当前圈右列
                    res.add(matrix[curR][dC]);
                    curR++;
                }
                while (curC!=sC){ //当前圈底行
                    res.add(matrix[dR][curC]);
                    curC--;
                }
                while (curR!=sR){ //当前圈左列
                    res.add(matrix[curR][sC]);
                    curR--;
                }
            }
            sR++;
            sC++;
            dR--;
            dC--;
        }
        return res;
    }
}