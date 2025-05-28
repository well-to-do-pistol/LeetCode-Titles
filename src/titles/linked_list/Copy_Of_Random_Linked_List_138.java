package titles.linked_list;

import java.util.*;

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

    // O(1)空间复杂度. 3次for循环
    // 第一次: 制造head的影子1->1'
    // 第二次: 利用newNode.random =  node.random.next来顺利获得random
    // 第三次: 分开影子
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        for(Node node=head; node!=null; node=node.next.next){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        for(Node node=head; node!=null; node=node.next.next){
            node.next.random = node.random==null ? null : node.random.next;
        }
        Node newHead = head.next;
        for(Node node=head; node!=null; ){
            Node newNode = node.next;
            node.next = newNode.next;     // 需要在newNode.next变之前获得
            newNode.next = newNode.next==null ? null : newNode.next.next;
            node = node.next;            // node是等于node.next不是newNode.next, newNode.next已经变了
        }
        return newHead;
    }

//    //O(n)空间复杂度. 用哈希表记录原来点与复制点之间的对应关系
//    //用回溯返回哈希表中当前点对应的复制点
//    //分别指定next和random, 用递归得到
//     HashMap<Node,Node> map = new HashMap<>();
//     public Node copyRandomList(Node head) {
//        if (head==null)return null;
//        if (!map.containsKey(head)){
//            Node newHead=new Node(head.val);
//            map.put(head,newHead);//先加了再说
//            newHead.next=copyRandomList(head.next);
//            newHead.random=copyRandomList(head.random);
//        }
//        return map.get(head);
//     }
}
