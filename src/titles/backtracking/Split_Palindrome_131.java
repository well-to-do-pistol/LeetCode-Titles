package titles.backtracking;
import java.util.*;
public class Split_Palindrome_131 {
    
}
class Solution {
    List<List<String>> res;
    List<String> path;
    // 用i=index作为第一种分割点，分割后判断回文，然后+1递归继续分割
    // 但是for循环里i++后会作为第二种、第三种分割点，分割判断再递归
    // 由此遍历所有可能
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        int n = s.length();
        backTracking(s,0,n);
        return res;
    }

    private void backTracking(String s, int index, int n){
        if (index==n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=index;i<n;++i){  
            if (isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
            }else continue;
            backTracking(s,i+1,n);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

}