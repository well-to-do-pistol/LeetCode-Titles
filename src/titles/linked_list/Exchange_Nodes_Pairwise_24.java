package titles.linked_list;

import java.util.*;

public class Exchange_Nodes_Pairwise_24 {
}

class Solution_24 {

    // dummyH
    // 1234
    // 2134
    // 2143
    public ListNode swapPairs(ListNode head) {
        ListNode dummyH = new ListNode(-1);
        dummyH.next = head;
        ListNode cur = dummyH;
        while(cur.next!=null && cur.next.next!=null){
            ListNode tmp = cur.next.next;  // 保存一下2
            cur.next.next = tmp.next;      // 1后接3
            tmp.next = cur.next;           // 2后接1
            cur.next = tmp;                // dummyH后接2
            cur = cur.next.next;
        }
        return dummyH.next;
    }
}
