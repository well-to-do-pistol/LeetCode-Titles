package titles.backtracking;
import java.util.*;
public class Phone_Number_Letter_Combination_17 {
    
}

class Solution_17 {
    List<String> res;
    StringBuilder path;
    String[] strs;  // 数组比map快
    int n;
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if(n==0)return new ArrayList<>();
        strs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res = new ArrayList<>();
        path = new StringBuilder();
        backTracking(digits,0);
        return res;
    }

    private void backTracking(String digits, int i){
        if (path.length()==n){
            res.add(new String(path)); // path要重复利用
            return;
        }
        for (;i<n;++i){
            String str = strs[digits.charAt(i)-'0'];
            for(char j : str.toCharArray()){
                path.append(j);
                backTracking(digits,i+1);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}