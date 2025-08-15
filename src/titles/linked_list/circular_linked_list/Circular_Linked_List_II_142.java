package titles.linked_list.circular_linked_list;


public class Circular_Linked_List_II_142 {
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


class Solution_142 {

    // 相交后, 慢指针回到起点, 两个指针每次走一步, 再次相交则为环的入口
    // l慢指针长度
    // x起点到入口长度
    // y入口到交点长度
    // z交点到入口长度
    // x+y=l
    // x+y+n(y+z)=2l
    // 化简得到(n-1)(y+z)+z=x
    // 无论如何等式都成立, 数学上可以假设当n==1时, x=z
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){  //因为我不想先移动快慢指针(这种看起来更复杂), 所以在while判空
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)break;
        }
        if(fast==null || fast.next==null)return null;
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}