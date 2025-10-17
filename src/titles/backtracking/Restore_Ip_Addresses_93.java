package titles.backtracking;
import java.util.*;
public class Restore_Ip_Addresses_93 {
}
class Solution_93 {

    /**
     11.11.11.11
     0   1  2 3
     */
    // 直接截取字符串,substring来每段每段去判断
    // Integer.parseInt
    // StringBuilder.setLength(len)来回溯
    // 记录多少段，有4段就添加

    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0,0,new StringBuilder());
        return res;
    }

    private void backTrack(String s, int start, int count, StringBuilder sb) {
        if (count==4 && start==s.length()) {
            res.add(sb.toString());
            return;
        }
        if (count>=4)
            return;

        int len = sb.length();
        for (int i=1; i<=3; ++i) {
            if (start+i>s.length())
                break;
            if (i>1 && s.charAt(start)=='0') break;
            String part = s.substring(start,start+i);
            if (Integer.parseInt(part) > 255) break;
            sb.append(part);
            if (count<3) sb.append(".");
            backTrack(s,start+i,count+1,sb);
            sb.setLength(len);
        }
    }
}