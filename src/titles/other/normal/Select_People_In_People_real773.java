package titles.other.normal;
import java.util.*;
public class Select_People_In_People_real773 {
}



class Main_773 {
    /**
     * 1.我的写法（其实差不多）
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(), k = in.nextInt(), a = in.nextInt(), b = in.nextInt();
//        int[] res = new int[n];
//        for (int i=0; i<n; ++i) {
//            if (in.nextInt()>=a) {
//                ++res[i];
//            }
//        }
//        for (int i=0; i<n; ++i) {
//            if (in.nextInt()>=b) {
//                ++res[i];
//            }
//        }
//        // 大于2为n-1种
//        int count=0;
//        for (int i=0; i<n; ++i) {
//            if (res[i]==2) {
//                int j=i;
//                while(i<n-1 && res[++i]==2)
//                    if (i-j+1>=k)
//                        ++count;
//            }
//        }
//        System.out.println(count);
//        // System.out.println(Arrays.toString(res));
//    }


    /**
     *  2. 滑窗写法
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        int[] res = new int[n];

        // 第一轮输入能力值 >= a
        for (int i = 0; i < n; ++i) {
            if (in.nextInt() >= a) {
                ++res[i];
            }
        }

        // 第二轮输入合作值 >= b
        for (int i = 0; i < n; ++i) {
            if (in.nextInt() >= b) {
                ++res[i];
            }
        }

        // 转换成 available 数组：满足两个条件才标记 1
        for (int i = 0; i < n; ++i) {
            res[i] = (res[i] == 2 ? 1 : 0);
        }

        // 滑动窗口：检查长度为 k 的区间是否全为 1
        int count = 0;
        int windowSum = 0;

        // 初始化前 k 个的和
        for (int i = 0; i < k; ++i) {
            windowSum += res[i];
        }
        if (windowSum == k) count++;

        // 向右滑动窗口
        for (int i = k; i < n; ++i) {
            windowSum += res[i] - res[i - k];
            if (windowSum == k) {
                count++;
            }
        }

        System.out.println(count);
    }
}




