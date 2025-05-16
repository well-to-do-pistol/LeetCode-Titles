package titles.backtracking;

import java.util.*;
public class Bracket_Generation_22 {
    
}

class Solution_22 {
    // 组合、排列、括号都要想到回溯
    // 如果左小于n, 加左
    // 如果右小于左，加右
    // 第一遍 ((()))
    // 二  减去最后  ((()) 一直减到剩2左，再(()())
    // 三  再减到(()， 到 (())()
    // 四  再减到(,    到 ()(())
    // 五  再减到()(， 到 ()()()
    List<String> res;
    StringBuilder path;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        path = new StringBuilder();
        backTracking(n,0,0);
        return res;
    }

    private void backTracking(int n,int l, int r){
        if(path.length()==2*n){
            res.add(new String(path)); //path要重复利用
            return;
        }
        if (l<n){
            path.append('(');
            backTracking(n,l+1,r);
            path.deleteCharAt(path.length()-1);
        }
        if (r<l){
            path.append(')');
            backTracking(n,l,r+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}