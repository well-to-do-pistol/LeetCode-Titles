package titles.array.matrix;

import java.util.*;

public class Spiral_Matrix_54 {
}

class Solution_54 {
    // 使用四个指针
    // 外层循环为while, 判断四个指针分别小于等于
    // 遍历完, 则更新当前边对应的指针, 比如遍历了上层行, 则--rS
    // 对于第三个第四个for循环, 由于rS和cE的变化, 必须添加判断它们没有越界, 不然会重复遍历
    // 对于3X3矩阵, 第二次while循环之后只会执行一次for循环
    // 对于4X3矩阵, 第二次while循环之后也只会执行一次for循环
    // 对于4X4矩阵, 第二次while循环之后只会执行第1,3,4个for循环(先遍历第一行, 再遍历最后一列和第一列(它们合起来就是第二行))
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int cS = 0, cE = matrix[0].length-1;
        int rS = 0, rE = matrix.length-1;
        int i;
        while(cS<=cE && rS<=rE){
            for(i=cS; i<=cE; ++i)
                res.add(matrix[rS][i]);
            ++rS;
            for(i=rS; i<=rE; ++i)
                res.add(matrix[i][cE]);
            --cE;
            for(i=cE; i>=cS; --i)
                res.add(matrix[rE][i]);
            --rE;
            for(i=rE; cS<=cE && i>=rS; --i)
                res.add(matrix[i][cS]);
            ++cS;
        }
        return res;
    }
}