package titles.dynamic_programming.variants_normal;
import java.util.*;
public class Yang_Hui_Triangle_118 {
}
class Solution_118 {
    //
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        res.add(one);
        for (int i=1; i<numRows; ++i){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j=1; j<i; ++j){
                tmp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}