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
    // A->B->C变成A->A'->B->B'->C->C'
    // 利用A的next获得影子节点，这样就获得影子的random
    // 断开（直接连一遍，注意有空节点，报错就打印看看谁有null，分析原因）
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        for (Node node=head; node!=null; node=node.next.next) {
            Node tmp = node.next;
            node.next = new Node(node.val);
            node.next.next = tmp;
        }
        for (Node node=head; node!=null; node=node.next.next) {
            node.next.random = node.random == null ? null : node.random.next;
        }
        Node res = head.next;
        for (Node node=head; node!=null; node=node.next) {
            Node tmp = node.next;                  // A'
            node.next = node.next.next;            // A连B
            tmp.next = node.next == null ? null : node.next.next;             // node.next可能等于null, A'连B'
        }
        return res;
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
