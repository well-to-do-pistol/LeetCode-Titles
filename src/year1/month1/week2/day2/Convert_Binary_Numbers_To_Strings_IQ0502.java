package year1.month1.week2.day2;

public class Convert_Binary_Numbers_To_Strings_IQ0502 {
}
class Solution_IQ0502 {
    //数字*2等于二进制小数点向右移动一位
    //只需要每次*2, 取整数部分就行了
    //0.101的两倍是1.01, 我们只需要让下一位突出来
    public String printBin(double num) {
        StringBuffer sb = new StringBuffer("0.");
        while (sb.length()<=32 && num!=0){
            num*=2;
            int x = (int) num;
            sb.append(x);
            num-=x;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
