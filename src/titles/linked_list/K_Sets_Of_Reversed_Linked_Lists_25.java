package titles.linked_list;

import java.util.*;

public class K_Sets_Of_Reversed_Linked_Lists_25 {
}

class Solution_25 {

    // 1. 精简版: 先反转, 然后dummyH接3, 尾接4
    // 记录四变量: pre head tail tmp
    // 技巧: 1. 先让tail为pre, 移动tail
    //      2. 连接更新完马上更新3个变量, 同一位置更新
    //      3. firstRound是扯淡
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyH = new ListNode(-1);
        dummyH.next = head;
        ListNode pre = dummyH;

        while(head!=null){                               // 改成while(true)也可以的
            ListNode tail = pre;
            for(int i=0; i<k; i++){
                tail = tail.next;                        // 先移动再判断, 之前先判断再移动蠢到我了
                if(tail==null)return dummyH.next;
            }

            ListNode tmp = tail.next;
            reverse(head,tail);
            head.next = tmp;
            pre.next = tail;
            pre = head;
            head = tmp;
        }
        return dummyH.next;
    }

    // 2. 自己想的简陋版 : 先反转, 然后dummyH接3, 尾接4
    // 记录四个变量, pHead, head, tail, tmp(tail.next)
    // cur要变成head, 所以第一次定义cur以及连接之后就要马上将head变成cur
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     ListNode cur = new ListNode(-1);
    //     cur.next = head;
    //     head = cur;
    //     ListNode res = cur, pHead, tail, tmp;
    //     // boolean isFirstRound=true;
    //     while(true){
    //         cur = head;               // 游标cur应该要等于头
    //         pHead = head;             // 新的pHead应该等于头(因为头已经变了尾)
    //         head = head.next;
    //         for(int i=0; i<k; i++){
    //             if(cur==null)return res.next;
    //             cur = cur.next;
    //         }
    //         if(cur==null)return res.next;      //如果cur中途为null或者最后变成了null,则返回
    //         tail = cur; tmp = cur.next;
    //         reverse(head,tail);
    //         head.next = tmp;
    //         pHead.next = tail;
    //         // if(isFirstRound)
    //         //     res.next = tail;
    //         // isFirstRound = false;
    //     }
    // }

    private void reverse(ListNode head, ListNode tail){
        ListNode pre = null;
        while(pre!=tail){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
    }
}
