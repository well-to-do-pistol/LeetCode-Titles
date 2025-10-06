package titles.prefix_sum.Differential_Array;

public class Flight_Reservation_Statistics_1109 {
}
class Solution_1109 {
    // 使用差分数组，把所有变化累积，然后算前缀和，最后一次添加到a数组上
    // 用a记录原始数组，b记录差分数组，大小时n+2
    // 更新时b[l]+=k，b[r+1]-=k，为了l到r算前缀和时+k，r之后抵消掉+k的影响
    // b算前缀和1到n
    // 将b加到a上，1到n
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] a = new int[n];
        int[] b = new int[n+2];
        for (int[] booking : bookings) {
            int l = booking[0];
            int r = booking[1];
            int k = booking[2];
            b[l]+=k;
            b[r+1]-=k;
        }
        for (int i=1; i<=n; ++i) {
            b[i]+=b[i-1];
        }
        for (int i=0; i<n; ++i) {
            a[i]+=b[i+1];
        }
        return a;
    }
}