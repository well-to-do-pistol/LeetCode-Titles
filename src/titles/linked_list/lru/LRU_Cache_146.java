package titles.linked_list.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache_146 {
}
class Node{
    int key;               //在map中移除最后节点需要key
    int val;
    Node pre;
    Node next;
    Node(){}
    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}

class LRUCache {

    Map<Integer,Node> map;
    int capacity;
    int size;
    Node dummyH;
    Node dummyT;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        this.size=0;
        dummyH = new Node();
        dummyT = new Node();
        dummyH.next=dummyT;
        dummyT.pre=dummyH;
    }

    public int get(int key) {      //get了之后要更新
        Node tmp = map.get(key);
        if (tmp==null)
            return -1;
        else{
            moveToHead(tmp);
            return tmp.val;
        }
    }

    public void put(int key, int value){
        Node tmp = map.get(key);
        if(tmp==null){
            tmp = new Node(key,value);
            map.put(key,tmp);
            addToHead(tmp);
            ++size;
            if (size>capacity) {
                deleteTail();
                --size;
            }
        }else{
            tmp.val=value;
            moveToHead(tmp);
        }
    }

    private void delete(Node tmp){
        tmp.next.pre=tmp.pre;
        tmp.pre.next=tmp.next;
    }

    private void deleteTail(){
        map.remove(dummyT.pre.key);
        delete(dummyT.pre);
    }

    private void addToHead(Node tmp){
        tmp.next=dummyH.next;
        dummyH.next.pre=tmp;
        dummyH.next=tmp;
        tmp.pre=dummyH;
    }

    private void moveToHead(Node tmp){
        delete(tmp);
        addToHead(tmp);
    }
}