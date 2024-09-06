package year1.month1.week2.day2;

public class Intersection_Linked_List_160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(4);
        headA.next=new ListNode(2);
        headA.next.next=new ListNode(3);
        headB.next=new ListNode(5);

        Solution_160 solution160=new Solution_160();
        solution160.getIntersectionNode(headA,headB);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution_160 {
    //简便写法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null)return null;
        ListNode f1=headA;
        ListNode f2=headB;
        while (f1!=f2){
            f1 = f1==null ? headB : f1.next;
            f2 = f2==null ? headA : f2.next;
        }
        return f1;
    }

    //双指针法
    //f1遍历到空,转到headB
    //f2遍历到空,转到headA, 这种方法能抵消两个链表的长度差最终找到相交节点
    //第二遍的肯定要么同时到尾要么同时到相交
    //m+n时间复杂度
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA==null || headB==null)return null;
//        ListNode f1=headA;
//        ListNode f2=headB;
//        while (f1!=null || f2!=null){
//            if (f1==f2)
//                return f1;
//            if (f1==null) {//等于null也要遍历第二个啊
//                f1 = headB;
//                f2 = f2.next;
//            } else if (f2==null) {
//                f2 = headA;
//                f1 = f1.next;
//            } else {
//                f1 = f1.next;
//                f2 = f2.next;
//            }
//        }
//        return null;
//    }
}