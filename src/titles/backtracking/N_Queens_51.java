package titles.backtracking;
import java.util.*;


class Solution_51 {
    // 不能上下左右，会导致莫名错误
    // 在每行列出所有列的可能，一旦标记Q，马上跳下一行
    // check的时候只check列就可以了，当前行不会有人和你争
    // 斜线的话遍历左上和右上就可以了
    List<List<String>> res;
    char[][] path;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        path = new char[n][n];
        for (int i=0; i<n; ++i)
            Arrays.fill(path[i],'.'); //这里是path[i]不是简单的path
        
        backTracking(0,n);
        return res;
    }

    private void backTracking(int i, int n){
        if (i==n){
            List<String> tmp = new ArrayList<>();
            for (int k=0; k<n; ++k){ 
                tmp.add(new String(path[k]));       // char[]也能直接new String哟
            }
            res.add(tmp);
            return;
        }

        for (int j=0; j<n; ++j){
            if (check(i,j,n)){
                path[i][j]='Q';
                backTracking(i+1,n);
                path[i][j]='.';
            }
        }
    }

    private boolean check(int i, int j, int n){
        //检查列
        for (int ni=0; ni<i; ++ni){
            if (path[ni][j]=='Q')
                return false;
        }
        //检查斜线左上
        for (int ni=i-1,nj=j-1; ni>=0 && nj>=0; --ni,--nj){
            if (path[ni][nj]=='Q')
                return false;
        }
        //检查斜线右上
        for (int ni=i-1,nj=j+1; ni>=0 && nj<n; --ni,++nj){
            if (path[ni][nj]=='Q')
                return false;
        }
        return true;
    }
}