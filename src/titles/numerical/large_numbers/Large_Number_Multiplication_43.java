package titles.numerical.large_numbers;

public class Large_Number_Multiplication_43 {
}
class Solution_43 {
    // 大数就是会超界
    // 一个数一个数相乘，倒序相乘，放在指定位置，比如12乘34,1乘4和2乘3的位置相同
    // 然后后一位就取除（算得进位），本位就取模
    // 最后还要判断前导零，减索引
    // 然后加进sb就行了
    public String multiply(String num1, String num2) {
        int n1=num1.length(),n2=num2.length();
        int[] nums = new int[n1+n2];
        for (int i=n1-1; i>=0; --i) {
            for (int j=n2-1; j>=0; --j) {
                nums[n1-1-i+n2-1-j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        for (int i=0; i<n1+n2-1; ++i) {
            nums[i+1]+=nums[i]/10;
            nums[i]%=10;
        }
        int tail=n1+n2-1;
        while(tail>0 && nums[tail]==0)  {
            --tail;
        }
        StringBuilder sb = new StringBuilder();
        for ( ;tail>=0; --tail) {
            sb.append(nums[tail]);
        }
        return sb.toString();
    }
}