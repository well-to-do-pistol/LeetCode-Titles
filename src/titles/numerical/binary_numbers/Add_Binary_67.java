package titles.numerical.binary_numbers;

public class Add_Binary_67 {
}
class Solution_67 {
    // 1. 最优写法
    // 用sb加，最后reverse
    // 和两数相加一样（但是从后面加起），carry也加进循环
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1,carry=0;
        StringBuffer sb = new StringBuffer();
        while (i>=0 || j>=0 || carry>0) {
            int v1 = i>=0 ? a.charAt(i--)-'0' : 0;
            int v2 = j>=0 ? b.charAt(j--)-'0' : 0;
            int sum = v1+v2+carry;
            sb.append((char)(sum%2+'0'));
            carry=sum/2;
        }
        return sb.reverse().toString();
    }


    // 2.可能快一点的写法
    // 转成整数，然后两数相加
    // 用char[]记录，最后根据索引new String
    // 从后往前加
    // 利用'0'算出整型
    // new String(res,开头,长度);
    // public String addBinary(String a, String b) {
    //     int i=a.length()-1, j=b.length()-1, carry=0;
    //     char[] res = new char[Math.max(a.length(),b.length())+2];
    //     int index = res.length - 1;
    //     while (i>=0 || j>=0 || carry>0) {
    //         int v1 = i>=0 ? a.charAt(i--)-'0' : 0;
    //         int v2 = j>=0 ? b.charAt(j--)-'0' : 0;
    //         int sum = v1+v2+carry;
    //         res[index--] = (char)(sum%2+'0');
    //         carry = sum/2;
    //     }

    //     return new String(res,index+1,res.length-(index+1));
    // }
}