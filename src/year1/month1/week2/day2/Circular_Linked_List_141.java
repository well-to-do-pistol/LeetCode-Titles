package year1.month1.week2.day2;

public class Circular_Linked_List_141 {
}
class Solution_141 {
    //快慢相交之后
    //快回到开头一步一步走
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null)return false;
        ListNode f1=head.next;
        ListNode f2=head.next.next;
        while (f1!=null && f2!=null && f2.next!=null){
            if (f1==f2)
                return true;
            f1=f1.next;
            f2=f2.next.next;
        }
        return false;
    }
}