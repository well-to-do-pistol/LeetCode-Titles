package titles.backtracking.variants_normal;

public class Word_Search_79 {
    
}

class Solution_79 {
    // 注意要连续，不能用重复，可以用boolean数组，但是直接标记更高效
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        char c = chars[0];
        for (int i=0; i<m; ++i){
            for (int j=0; j<n; ++j){
                if (board[i][j]==c){
                    if(bfs(board,chars,i,j,1,chars.length,m,n))
                        return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private boolean bfs(char[][] board, char[] chars, int i, int j, int index, int end, int m, int n){
        if (index==end){
            return true;
        }
        
        char tmp = board[i][j];
        board[i][j]='#';
        
        for (int[] dir : dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if (newI>=0 && newI<m && newJ>=0 && newJ<n && board[newI][newJ]==chars[index]){
                if (bfs(board,chars,newI,newJ,index+1,end,m,n))
                    return true;
            }
        }

        board[i][j]=tmp;
        return false;
    }
}