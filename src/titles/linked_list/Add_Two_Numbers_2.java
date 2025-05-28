package titles.linked_list;

import java.util.*;

public class Add_Two_Numbers_2 {
}

class Solution_2 {

    // 直接相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyH = new ListNode(-1);
        ListNode cur = dummyH;
        int aBit = 0, sum;
        boolean n1,n2;
        while(l1!=null || l2!=null || aBit!=0){
            n1 = l1==null; n2 = l2==null;
            sum = (n1 ? 0 : l1.val) + (n2 ? 0 : l2.val) + aBit;
            cur.next = new ListNode(sum%10);
            aBit = sum/10;
            cur = cur.next;
            if(!n1)l1 = l1.next;
            if(!n2)l2 = l2.next;
        }
        return dummyH.next;
    }
}
