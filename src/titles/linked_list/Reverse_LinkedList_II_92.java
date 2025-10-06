package titles.linked_list;

public class Reverse_LinkedList_II_92 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre=null, cur=null, subTail=null, l = dummyHead;
        for (int i=1; i<left; ++i)
            l=l.next;
        cur=l.next;
        subTail=cur;
        while (left<=right && cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            ++left;
        }
        ListNode r = cur;
        l.next = pre;
        subTail.next = r;
        return dummyHead.next;
    }
}