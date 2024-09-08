package year1.month1.week2.day2;

public class Sort_Linked_List_148 {
}
class Solution_148 {
    //自顶向下归并
    //一定要注意, 等于两个的时候,要断开连接,只拿head, 因为123null会分为123,3null->然后是12 23
    //而且fast一定要一步一步走,不是tail的时候才多走一步
    //其实只会排两个节点的情况
    public ListNode sortList(ListNode head) {
        return mergeSort(head,null);
    }

    private ListNode mergeSort(ListNode head, ListNode tail) {
        if (head==null)return null;
        if (head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if (fast!=tail)
                fast=fast.next;
        }
        ListNode list1=mergeSort(head,slow);
        ListNode list2=mergeSort(slow,tail);
        return mergeM(list1,list2);
    }

    private ListNode mergeM(ListNode head1, ListNode head2) {
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while (head1!=null && head2!=null){
            if (head1.val<=head2.val){
                cur.next=head1;
                head1=head1.next;
            }
            else {
                cur.next=head2;
                head2=head2.next;
            }
            cur=cur.next;
        }
        cur.next=head1==null?head2:head1;
        return dummy.next;
    }
}







//class Solution_148 {
//    //自底向上归并排序(利用数组长度, 从1开始, 每次*2)
//    //先merge(合并链表)前两个数组,如果还有,则将循环
//    //要有pre和cur
//    //注意数组没排序完的情况, head1必不为null, head2可能为null, 同时记得断开连接
//    public ListNode sortList(ListNode head) {
//        if (head==null)return null;
//        int totalLen=0;
//        for (ListNode cur=head; cur!=null; cur=cur.next)totalLen++;
//        ListNode dummy=new ListNode(0,head);
//        for (int subLen=1; subLen<totalLen; subLen*=2){
//            ListNode pre = dummy;
//            ListNode cur = dummy.next;
//            while (cur!=null){
//                ListNode head1 =cur;
//                for (int i=1; i<subLen && cur.next!=null; i++)cur=cur.next;
//                ListNode head2 = cur.next;
//                //head1最后一个节点的下一个设为null
//                cur.next=null;
//                cur=head2;
//                for (int i=1; i<subLen && cur!=null && cur.next!=null; i++)cur=cur.next;
//                //如果数组还没排序完, 找出next
//                ListNode next=null;
//                if (cur!=null) {   //如果数组没排序完, head1必不为null,但head2可能为null
//                    next = cur.next;
//                    //head2最后一个节点的下一个设为null
//                    cur.next = null;
//                }
//                ListNode preNext=mergeM(head1,head2);
//                pre.next=preNext; //连接上排序好的
//                while (pre.next!=null)pre=pre.next; //如果还没排序完,那么pre更新为head1和head2排序后的最后一个节点
//                cur=next;
//            }
//        }
//        return dummy.next;
//    }
//
//    private ListNode mergeM(ListNode head1, ListNode head2) {
//        ListNode dummy=new ListNode(0);
//        ListNode cur=dummy;
//        while (head1!=null && head2!=null){
//            if (head1.val<=head2.val){
//                cur.next=head1;
//                head1=head1.next;
//            }
//            else {
//                cur.next=head2;
//                head2=head2.next;
//            }
//            cur=cur.next;
//        }
//        cur.next=head1==null?head2:head1;
//        return dummy.next;
//    }
//}