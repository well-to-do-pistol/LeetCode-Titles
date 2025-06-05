package titles.numerical.large_numbers;

public class Large_Number_Multiplication_43 {
}
class Solution_43 {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))return "0";
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] values = new int[len1+len2];
        for(int i=len1-1; i>=0; --i){
            for(int j=len2-1; j>=0; --j){
                values[len1-1-i+len2-1-j]+=(c1[i]-'0')*(c2[j]-'0');
            }
        }
        //计算进位
        for (int i=0; i<len1+len2-1; ++i){
            values[i+1]+=values[i]/10;
            values[i]%=10;
        }
        int index=len1+len2-1;
        while (values[index]==0){
            --index;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=index; i>=0; --i){
            sb.append(values[i]);
        }
        return sb.toString();
    }
}