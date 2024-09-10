package year1.month1.week2.day2;

import java.util.ArrayList;
import java.util.List;

public class Brackets_Generation_22 {
}
class Solution_22 {
    //回溯
    //如果左小于n,加左
    //如果右小于左,加右
    List<String>res=new ArrayList<>();
    StringBuffer path=new StringBuffer();
    public List<String> generateParenthesis(int n) {
        traversal(n,0,0);
        return res;
    }

    private void traversal(int n, int left,int right) {
        if (path.length()==2*n){
            res.add(new String(path));
            return;
        }
        if (left<n){
            path.append("(");
            traversal(n,left+1,right);
            path.deleteCharAt(path.length()-1);
        }
        if (right<left){
            path.append(")");
            traversal(n,left,right+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}