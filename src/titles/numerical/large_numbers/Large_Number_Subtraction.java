package titles.numerical.large_numbers;

public class Large_Number_Subtraction {

}
class Solution_lns__ {

    public boolean compare(String num1, String num2){
        if (num1.length()>num2.length()){
            return true;
        } else if (num1.length()<num2.length()) {
            return false;
        }else {
            return num1.compareTo(num2)>0;
        }
    }

    public String subtractStrings(String num1, String num2) {
        char sign = '+';
        if(!compare(num1,num2)){
            sign='-';
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int borrow=0;
        StringBuilder sb = new StringBuilder();
        while (len1>0 || len2>0){
            int n1 = len1>0 ? c1[--len1]-'0' : 0;
            int n2 = len2>0 ? c2[--len2]-'0' : 0;
            int x = n1-n2-borrow;
            borrow=0;
            if(x<0){
                borrow=1;
                x+=10;
            }
            sb.append(x);
        }
        sb.reverse(); //String 在 Java 中是不可变的, 但sb可变
        int index=0;
        if (index<sb.length() && sb.charAt(index)=='0'){
            ++index;
        }
        if (index==sb.length())
            return "0";
        if(sign=='+')
            return sb.substring(index);
        else
            return sign+sb.substring(index);
    }
}
