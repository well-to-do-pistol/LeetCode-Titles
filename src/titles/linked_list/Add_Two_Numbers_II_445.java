package titles.linked_list;

public class Add_Two_Numbers_II_445 {
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(addTwoNode(l1,l2));
    }

    private ListNode addTwoNode(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int up = 0,sum = 0;
        while (l1!=null || l2!=null) {
            sum = (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val) + up;
            up = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1!=null)
                l1 = l1.next;
            if (l2!=null)
                l2 = l2.next;
        }
        if (up!=0) {
            cur.next = new ListNode(up);
        }
        return dummyHead.next;  // return 的是dummyHead.next
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while(node!=null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }
}