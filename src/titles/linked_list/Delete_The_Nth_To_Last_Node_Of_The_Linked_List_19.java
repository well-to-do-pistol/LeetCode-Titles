package titles.linked_list;

import java.util.*;

public class Delete_The_Nth_To_Last_Node_Of_The_Linked_List_19 {
}

class Solution_19 {

    // 1. dummyH加快慢指针(快慢都只走一步), dummyH为了一开始慢指针不走出界
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyH = new ListNode(-1);
        dummyH.next = head;
        ListNode slow = dummyH, fast = dummyH;
        for(int i=0; i<=n; ++i){
            slow = slow.next;
        }
        while(slow!=null){
            slow = slow.next;
            fast = fast.next;
        }
        if(fast.next!=null)fast.next = fast.next.next;
        return dummyH.next;
    }


    // 2. 自己想的: 遍历得到长度len, 再遍历得到删除点的pre
    // 主要要判断当要删除的点为头时的特殊情况
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode cur = head;
    //     int len=0;
    //     while(cur!=null){
    //         ++len;
    //         cur = cur.next;
    //     }
    //     n = len-n-1;
    //     if(n<=-1)return head.next; //当要删除的点为头时
    //     cur = head;
    //     for(int i=0; i<n; ++i){
    //         cur = cur.next;
    //     }
    //     cur.next = cur.next.next;
    //     return head;
    // }
}