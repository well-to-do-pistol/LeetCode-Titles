package titles.linked_list.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache_146 {
}

// 1. 用数组和双向链表(头和尾组成)
class LRUCache {

    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        Node(){}
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node[] cache;
    Node head;
    Node tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        cache = new Node[10001];
        size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache[key];
        if(node==null){
            return -1;
        }else{
            moveHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = cache[key];
        if(node==null){
            Node newNode = new Node(key, value);
            cache[key]=newNode;
            addHead(newNode);
            ++size;
            if(size>capacity){
                removeTail();
                --size;
            }
        }else{
            moveHead(node);
            node.val=value;
        }
    }

    private void addHead(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void moveHead(Node node){
        remove(node);
        addHead(node);
    }

    private void remove(Node node){
        Node pre = node.pre;
        node.pre = null;
        pre.next = node.next;
        node.next.pre = pre;
        node.next = null;
    }

    private void removeTail(){
        Node remove = tail.pre;
        cache[remove.key] = null;
        remove(remove);
    }

}

// 2. 用map和双向链表(头和尾组成)
//class Node{
//    int key;               //在map中移除最后节点需要key
//    int val;
//    Node pre;
//    Node next;
//    Node(){}
//    Node(int key, int val){
//        this.key=key;
//        this.val=val;
//    }
//}
//
//class LRUCache {
//
//    Map<Integer,Node> map;
//    int capacity;
//    int size;
//    Node dummyH;
//    Node dummyT;
//
//    public LRUCache(int capacity) {
//        map=new HashMap<>();
//        this.capacity=capacity;
//        this.size=0;
//        dummyH = new Node();
//        dummyT = new Node();
//        dummyH.next=dummyT;
//        dummyT.pre=dummyH;
//    }
//
//    public int get(int key) {      //get了之后要更新
//        Node tmp = map.get(key);
//        if (tmp==null)
//            return -1;
//        else{
//            moveToHead(tmp);
//            return tmp.val;
//        }
//    }
//
//    public void put(int key, int value){
//        Node tmp = map.get(key);
//        if(tmp==null){
//            tmp = new Node(key,value);
//            map.put(key,tmp);
//            addToHead(tmp);
//            ++size;
//            if (size>capacity) {
//                deleteTail();
//                --size;
//            }
//        }else{
//            tmp.val=value;
//            moveToHead(tmp);
//        }
//    }
//
//    private void delete(Node tmp){
//        tmp.next.pre=tmp.pre;
//        tmp.pre.next=tmp.next;
//    }
//
//    private void deleteTail(){
//        map.remove(dummyT.pre.key);
//        delete(dummyT.pre);
//    }
//
//    private void addToHead(Node tmp){
//        tmp.next=dummyH.next;
//        dummyH.next.pre=tmp;
//        dummyH.next=tmp;
//        tmp.pre=dummyH;
//    }
//
//    private void moveToHead(Node tmp){
//        delete(tmp);
//        addToHead(tmp);
//    }
//}