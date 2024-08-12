package year1.month1.week1.day2;

public class Solving_Numerology_Puzzles_37 {
}

class Solution12 {
    //每次回溯都会重新从0，0开始遍历
    public void solveSudoku(char[][] board) {
        if(traversal(board))return;
    }

    private boolean traversal(char[][] board) {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='.'){
                    for (int k='1'; k<='9'; k++){
                        if (isValidMy(i,j,k,board)){//如果有效，进入回溯
                            board[i][j]= (char) k; //别忘记加了
                            if (traversal(board))return true;//一直遍历到最后，所有数字填满，就一直返回true
                            board[i][j]='.';//到这里证明填入数字是错的，回溯
                        }
                    }
                    return false; //9个数字遍历完也没有
                }
            }
        }
        return true; //只有到了最后，两层for循环遍历的全是'.', 就返回true
    }

    private boolean isValidMy(int row, int col, int val, char[][] board) {
        //检查列(行固定)
        for (int j=0; j<9; j++){
            if (board[row][j]==val)return false;
        }
        //检查行(列固定)
        for (int i=0; i<9; i++){
            if (board[i][col]==val)return false;
        }

        //检查九宫格
        int startRow = row/3*3;
        int startCol = col/3*3;
        for (int i=startRow; i<startRow+3; i++){
            for (int j=startCol; j<startCol+3; j++){
                if (board[i][j]==val)return false;
            }
        }
        return true;
    }
}