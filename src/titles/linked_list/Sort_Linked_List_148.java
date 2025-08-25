package titles.linked_list;

import java.util.*;

public class Sort_Linked_List_148 {
}

class Solution_148 {

    // 1. 自底向上归并排序(迭代), 时间复杂度O(nlogn), 空间复杂度O(1)
    // 先写出两个有序链表的合并
    // 然后用迭代自底向上的方法，从1-1合并成2，到2-2合并成4，一直合并
    // 需要记录pre cur h1 h2 next
    // h1和h2都要和后面的断开，用pre和next（next用来实时更新cur）进行重新连接，cur是用来遍历的
    public ListNode sortList(ListNode head) {
        int len = 0;
        for (ListNode node=head; node!=null; node=node.next) ++len;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE,head), pre, cur, h1, h2, next;
        for (int subLen=1; subLen<len; subLen<<=1) {
            pre =dummyHead; cur=dummyHead.next;
            while (cur!=null) {
                h1=cur;
                for (int i=1; i<subLen && cur.next!=null; ++i) cur = cur.next;
                h2=cur.next;
                cur.next=null;         // 断开h1与h2
                cur = h2;              // cur.next变成了null，cur要变回h2
                for (int i=1; i<subLen && cur!=null && cur.next!=null; ++i) cur = cur.next;
                if (cur!=null) {
                    next = cur.next;
                    cur.next = null;   // 断开h2与后续
                } else {
                    next = null;       // 如果cur没有了，next也要置为null，否则就无限循环了
                }
                pre.next = merge(h1,h2);
                while (pre.next!=null) pre=pre.next;    //  更新pre
                cur = next;                             //  更新cur
            }
        }
        return dummyHead.next;
    }

    private ListNode merge(ListNode h1, ListNode h2) {   // 排序不用新建节点啊
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), cur = dummyHead;
        while (h1!=null && h2!=null) {
            if (h1.val <= h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        cur.next = h1==null ? h2 : h1;
        return dummyHead.next;
    }


    // 2. 自顶向下归并排序(递归), 时间复杂度O(nlogn), 空间复杂度O(logn)
    // 重点关注3个的时候, 比如524, 变成52->直接断开变成5 和 24->直接断开变成2
    // 重点关注2个的时候, head.next==tail, 直接断开返回head
    // 重点关注null, 因为只有1个的情况被第二点包含了
    // 因为所有链都断开了, 后面就像合并链表一样easy
    // public ListNode sortList(ListNode head) {
    //     return partition(head, null);
    // }

    // private ListNode partition(ListNode head, ListNode tail){
    //     if(head==null)return null;
    //     else if(head.next==tail){
    //         head.next=null;
    //         return head;
    //     }
    //     ListNode slow = head, fast = head;
    //     while(fast!=tail && fast.next!=tail){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }
    //     ListNode l1 = partition(head,slow);
    //     ListNode l2 = partition(slow,tail);
    //     return mergeSort(l1,l2);
    // }

    // private ListNode mergeSort(ListNode l1, ListNode l2){
    //     ListNode dummyH = new ListNode(-1);
    //     ListNode cur = dummyH;
    //     while(l1!=null && l2!=null){
    //         if(l1.val <= l2.val){
    //             cur.next = l1;
    //             l1 = l1.next;
    //         }else{
    //             cur.next = l2;
    //             l2 = l2.next;
    //         }
    //         cur = cur.next;
    //     }
    //     cur.next = l1==null ? l2 : l1;
    //     return dummyH.next;
    // }
}