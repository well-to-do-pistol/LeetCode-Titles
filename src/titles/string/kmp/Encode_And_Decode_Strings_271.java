package titles.string.kmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Encode_And_Decode_Strings_271 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i=10; i>=0; --i) {
            StringBuilder sb = new StringBuilder();
            int j = random.nextInt(10);
            for (;j>=0;--j) {
                sb.append((char)('a'+random.nextInt(26)));
            }
            list.add(sb.toString());
        }
        String ss = s.enCode(list);
        List<String> sss = s.deCode(ss);
        System.out.println(ss);
        System.out.println(sss.toString());
    }
}

class Solution {
    // 长度+#+字符串
    public String enCode(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s:list) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    // 遍历字符串，遍历到#，用substring截取i到j，再截j+1,j+1+len，i=j+1+len
    public List<String> deCode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i<s.length()) {
            int j = i;
            while (j<s.length() && s.charAt(j)!='#') {
                ++j;
            }
            int len = Integer.parseInt(s.substring(i,j));
            res.add(s.substring(j+1,j+1+len));
            i = j+1+len;
        }
        return res;
    }
}