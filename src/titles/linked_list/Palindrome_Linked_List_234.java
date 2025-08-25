package titles.linked_list;

import java.util.*;

public class Palindrome_Linked_List_234 {
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution_234 {

    // 1. 快慢指针，找到第二条链的尾，反转，然后遍历比较，然后反转回来
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l1 = reverse(slow),l2=head;
        while (l1!=null) {
            if (l1.val!=l2.val)
                return false;
            l1=l1.next;
            l2=l2.next;
        }
        reverse(l1);
        return true;
    }

    // 2. 自己想的, 长度找中, 反转后半, 判断, 翻转回来
    // public boolean isPalindrome(ListNode head) {
    //     ListNode cur = head, pre;
    //     int len=0;
    //     while(cur!=null){
    //         cur = cur.next;
    //         ++len;
    //     }
    //     int n = len=len/2;
    //     cur=head;
    //     while(--n>=0){                         // 遍历总长的一半+1
    //         cur = cur.next;
    //     }
    //     ListNode tail = pre = reverse(cur);
    //     cur=head;
    //     while(pre!=null){
    //         if(pre.val != cur.val)return false; // 比较的是链表的val!!!
    //         pre = pre.next;
    //         cur = cur.next;
    //     }
    //     reverse(tail);
    //     return true;
    // }

    private ListNode reverse(ListNode cur){
        ListNode pre = null;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}