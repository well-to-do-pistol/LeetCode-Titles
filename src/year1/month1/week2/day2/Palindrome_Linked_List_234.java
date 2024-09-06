package year1.month1.week2.day2;

public class Palindrome_Linked_List_234 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        headA.next=n2;
        n2.next=n3;
        n3.next=n4;
        Solution_234 solution234 = new Solution_234();
        solution234.isPalindrome(headA);
        while (headA!=null){
            System.out.println(headA.val);
            headA=headA.next;
        }
    }
}
class Solution_234 {
    //方法1: 遍历所有节点放进数组,然后双指针判断相同
    //方法2:
    //快慢找中, 反转后半, 比较得boolean, 反转回来
    public boolean isPalindrome(ListNode head) {
        if (head==null)return true;
        ListNode start2 = findStart2(head);
        ListNode secondPart = reverseM(start2);

        boolean isPalin = true;
        ListNode f1=head;
        ListNode f2=secondPart;
        while (isPalin && f2!=null){ //f2不可能长过f1, 一定会提前退出
            if (f1.val!=f2.val) //比较值不是比较节点
                isPalin=false;
            f1=f1.next;
            f2=f2.next;
        }
        reverseM(secondPart); //应该不用指定吧
        return isPalin;
    }

    private ListNode reverseM(ListNode secondPart) {
        ListNode cur=secondPart;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    private ListNode findStart2(ListNode head) {
        ListNode f1=head;
        ListNode f2=head;
        while (f2!=null && f2.next!=null){ //先判断f1和f2.next
            f1=f1.next;
            f2=f2.next.next;
        }
        return f1;
    }
}