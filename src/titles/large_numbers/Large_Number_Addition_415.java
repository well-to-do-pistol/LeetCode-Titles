package titles.large_numbers;

public class Large_Number_Addition_415 {
}
class Solution_415 {
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        while (len1>0 || len2>0){
            int n1 = len1>0 ? c1[--len1]-'0' : 0;
            int n2 = len2>0 ? c2[--len2]-'0' : 0;
            int num = n1 + n2 + remainder;
            remainder = num/10;
            sb.append(num%10);
        }
        if(remainder>0){
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
}