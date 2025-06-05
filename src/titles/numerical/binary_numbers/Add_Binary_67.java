package titles.numerical.binary_numbers;

public class Add_Binary_67 {
}
class Solution_67 {
    // 和大数加法几乎一模一样
    public String addBinary(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int digitA = i>=0 ? ca[i--]-'0' : 0;
            int digitB = j>=0 ? cb[j--]-'0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum>=2 ? sum-2 : sum;    // 大于等于2即为sum-2
            sb.append(sum);
        }
        if (carry > 0)         // 不要忘了最后可能要加
            sb.append("1");
        return sb.reverse().toString();
    }
}