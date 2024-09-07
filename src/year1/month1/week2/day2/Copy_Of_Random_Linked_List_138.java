package year1.month1.week2.day2;

import java.util.HashMap;

public class Copy_Of_Random_Linked_List_138 {
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution_138 {
    //三次for循环
    //1.指定1-1'-2-2'
    //2.利用1的顺序拿到1'的random, 是1的random的next, 判空
    //3.利用1的顺序分别正常排序1'和1, 1'的next为1'的next的next, 判空
    //最后返回head.next(提前记录)
    public Node copyRandomList(Node head) {
        if (head==null)return null;
        for (Node node=head; node!=null; node=node.next.next){
            Node newNode=new Node(node.val);
            newNode.next=node.next;
            node.next=newNode;
        }
        for (Node node=head; node!=null; node=node.next.next){
            Node newNode=node.next;
            newNode.random=node.random!=null? node.random.next : null;
        }
        Node newHead=head.next;
        for (Node node=head; node!=null; node=node.next){ //只要有node,它的下一个必不为空, 因为node.next实际变成了node.next.next所以变成循环变化
            Node newNode=node.next;
            node.next=newNode.next;
            newNode.next=newNode.next!=null? newNode.next.next : null;
        }
        return newHead;
    }



//    //用哈希表记录原来点与复制点之间的对应关系
//    //用回溯返回哈希表中当前点对应的复制点
//    //分别指定next和random, 用递归得到
//    HashMap<Node,Node> map = new HashMap<>();
//    public Node copyRandomList(Node head) {
//        if (head==null)return null;
//        if (!map.containsKey(head)){
//            Node newHead=new Node(head.val);
//            map.put(head,newHead);//先加了再说
//            newHead.next=copyRandomList(head.next);
//            newHead.random=copyRandomList(head.random);
//        }
//        return map.get(head);
//    }
}