package titles.numerical.binary_numbers.normal;

public class Hamming_Weight_191 {
}
class Solution_191 {
    // i & (i-1)
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            ++res;
            n = n&(n-1);
        }
        return res;
    }
}