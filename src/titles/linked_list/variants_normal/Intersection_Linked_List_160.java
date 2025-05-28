package titles.linked_list.variants_normal;

import java.util.*;

public class Intersection_Linked_List_160 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {

    // 同时遍历, 直到相遇, 返回
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        while(cur1!=cur2){
            //转移头算一步, 不要动两步
            cur1 = cur1==null ? headB : cur1.next;
            cur2 = cur2==null ? headA : cur2.next;
        }
        return cur1;
    }
}