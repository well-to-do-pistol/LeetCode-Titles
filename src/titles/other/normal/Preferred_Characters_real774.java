package titles.other.normal;
import java.util.*;
public class Preferred_Characters_real774 {
}


class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Set<Character> fav = new HashSet<>();
        for (int i = 0; i < m; i++) {
            fav.add(in.next().charAt(0));
        }
        in.nextLine();
        char[] s = in.nextLine().toCharArray();

        // 找到第一个偏爱字符的位置
        int firstFav = -1;
        for (int i = 0; i < n; i++) {
            if (fav.contains(s[i])) {
                firstFav = i;
                break;
            }
        }

        // 如果开头有一段非偏爱字符，直接替换成第一个偏爱字符
        if (firstFav > 0) {
            Arrays.fill(s, 0, firstFav, s[firstFav]);
        }

        // 双指针遍历，处理相邻两个偏爱字符之间的区间
        int left = firstFav;
        for (int i = firstFav + 1; i < n; i++) {
            if (fav.contains(s[i])) {
                int right = i;
                // 中间非偏爱字符，前半段靠左替换，后半段靠右替换
                int mid = (left + right) / 2;
                Arrays.fill(s, left + 1, mid + 1, s[left]);
                Arrays.fill(s, mid + 1, right, s[right]);
                left = right; // 更新左指针
            }
        }

        // 处理末尾的非偏爱字符（全替换成最后一个偏爱字符）
        if (left < n - 1) {
            Arrays.fill(s, left + 1, n, s[left]);
        }

        System.out.println(new String(s));
    }
}