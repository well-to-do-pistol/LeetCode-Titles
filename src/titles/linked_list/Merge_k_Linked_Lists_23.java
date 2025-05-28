package titles.linked_list;

import java.util.*;

public class Merge_k_Linked_Lists_23 {
}

class Solution_23 {

    // 自顶向下归并排序(递归)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        return patition(lists, 0, lists.length-1);
    }

    private ListNode patition(ListNode[] lists, int l, int r){
        if(l==r)return lists[l];
        int mid = l+((r-l)>>1);
        ListNode l1 = patition(lists, l, mid);
        ListNode l2 = patition(lists, mid+1, r);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyH = new ListNode(-1);
        ListNode cur = dummyH;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
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
}
