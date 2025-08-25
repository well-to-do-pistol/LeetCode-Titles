package titles.linked_list;

import java.util.*;

public class Delete_The_Nth_To_Last_Node_Of_The_Linked_List_19 {
}

class Solution_19 {

    // 1. 要用dummyHead防止删除头部
    // 双指针，先走n步, 然后两个再一起走直到null
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || head.next==null) return null;
        ListNode dummyHead = new ListNode(-1,head), l1 = dummyHead, l2 = dummyHead;
        while (n-->=0) {     // 为了得到前一个节点，必须多走一次
            l1=l1.next;
        }
        while (l1!=null) {
            l1=l1.next;
            l2=l2.next;
        }
        l2.next = l2.next.next;
        return dummyHead.next;
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