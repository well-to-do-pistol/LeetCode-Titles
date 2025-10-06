package titles.greedy;
import java.util.Scanner;
import java.util.*;
public class Xiao_Hong_s_necklace_real801 {
}


/**
 重点是放数组里排序3个

 n>=3k先判断
 p1,p2,p3位置排序
 d1 = p2-p1, d2 = p3-p2, d3 = n-(p3-p1)距离排序
 如果需要,要移动k-d1和k-d2，d3作为盈余给前两个珠子消耗
 d3-k-(k-d1+k-d2) = n-3k>=0，所以给一开始判断就行

 结果就等于 max(0,k-d1)+max(0,k-d2)
 */
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0) {
            long n = in.nextLong(), k = in.nextLong();

            if (n<3*k) {
                System.out.println(-1);
                for (int i=0; i<3; ++i)
                    in.nextLong();
                continue;  // 记得要把数据先读了再continue
            }

            long[] ps = new long[3];
            ps[0] = in.nextLong();
            ps[1] = in.nextLong();
            ps[2] = in.nextLong();
            Arrays.sort(ps);

            long[] ds = new long[3];
            ds[0] = ps[1]-ps[0];
            ds[1] = ps[2]-ps[1];
            ds[2] = n-(ps[2]-ps[0]);
            Arrays.sort(ds);

            System.out.println(Math.max(0,k-ds[0]) + Math.max(0,k-ds[1]));
        }
    }
}