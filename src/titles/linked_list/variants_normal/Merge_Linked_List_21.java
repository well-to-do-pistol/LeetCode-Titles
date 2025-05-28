package titles.linked_list.variants_normal;

import java.util.*;

public class Merge_Linked_List_21 {
}

class Solution_21 {

    // 因为next只有一个, 所以不用担心会有遗留指向, 最终只会有dummyH一个遗留指向
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyH = new ListNode(-1);
        ListNode cur = dummyH;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1==null ? list2 : list1;
        return dummyH.next;
    }
}
