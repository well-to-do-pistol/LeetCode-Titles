package year1.month1.week2.day2;

public class Delete_The_Nth_To_Last_Node_Of_The_Linked_List_19 {
}
class Solution_19 {
    //移动n+1步
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast=dummy;
        for (int i=0; i<=n; i++){
            fast=fast.next;
        }
        ListNode slow=dummy;
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if (slow.next!=null) slow.next=slow.next.next;
        return dummy.next;
    }
}

