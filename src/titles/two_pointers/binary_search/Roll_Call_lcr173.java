package titles.two_pointers.binary_search;

public class Roll_Call_lcr173 {
}
//二分找最前面a[i]不等于i的数, 二分的精髓是逼近而不是直接相等
//如果用records[mid]!=mid判断int[] records = {0, 1, 2, 4, 4, 5};会失败
//- `i = 0`，`j = 5`
// - `m = 2`，`records[2] = 2 == 2` → `i = 3`
// - `m = 4`，`records[4] = 4 == 4` → `i = 5`
// - `m = 5`，`records[5] = 5 == 5` → `i = 6`
// - **返回值：**`6`（不正确）
class Solution_lcr173 {
    public int takeAttendance(int[] records) {
        int mid, l=0, r=records.length;
        while(l<r){
            mid=l+((r-l)>>1);
            if(records[mid]==mid)
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }
}