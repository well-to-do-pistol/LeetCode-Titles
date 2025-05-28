package titles.linked_list;

import java.util.*;

public class Sort_Linked_List_148 {
}

class Solution_148 {

    // 1. 自底向上归并排序(迭代), 时间复杂度O(nlogn), 空间复杂度O(1)
    // 先计算链表长度, 子数组长度为x=1开始, x*=2, 直到大于链表长度
    // 每次合并两个长度为x的子链表, 一直合并到终点, 然后长度*2继续
    // 注意要设dummyH, pre, cur(每次更新了长度都要重置), next; 注意每次链表的断开以及pre和cur的更新
    // for循环遍历子链的时候要注意判空
    // 就算左边是123, 右边是4=h2, 依旧要
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        int len = 0;
        for(ListNode cur=head; cur!=null; cur=cur.next)++len;
        ListNode dummyH = new ListNode(-1);
        dummyH.next=head;
        for(int subLen=1; subLen<len; subLen<<=1){
            ListNode pre=dummyH, cur=dummyH.next, h1, h2, next;  //head可能已经不在第二位了
            while(cur!=null){
                h1=cur;
                for(int i=1; i<subLen && cur.next!=null; ++i)cur=cur.next;
                h2=cur.next;
                cur.next=null;
                cur=h2;                             //要把cur跳到h2
                for(int i=1; i<subLen && cur!=null && cur.next!=null; ++i)cur=cur.next;
                next=null;                          //cur是有可能等于null的, 当长度为1, 但是只有左子链有1个元素的时候
                if(cur!=null){
                    next=cur.next;
                    cur.next=null;
                }
                pre.next=mergeSort(h1,h2);
                while(pre.next!=null) pre=pre.next; //必须遍历到下一pre
                cur=next;
            }
        }
        return dummyH.next;
    }

    private ListNode mergeSort(ListNode l1, ListNode l2){
        ListNode dummyH = new ListNode(-1);
        ListNode cur = dummyH;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null ? l2 : l1;
        return dummyH.next;
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