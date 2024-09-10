package year1.month1.week2.day2;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache_146 {
}
//建立双向链表和map, 用key对应
//在表头添加, 一旦有操作就移到链表
//创建容量和实际大小, 如果实际大小大于容量, 则删除表尾
//删除和添加记得map的对应关系
//设置dummy头和尾
class LRUCache {
    class DLinkedNode{
        int key; //key用来删除cache的对应的
        int val;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    HashMap<Integer,DLinkedNode> cache=new HashMap<>();
    int size;
    int capability;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        size=0;
        this.capability=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        DLinkedNode node=cache.get(key);
        if (node!=null){
            moveToHead(node);
            return node.val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node=cache.get(key);
        if (node==null){
            DLinkedNode newNode=new DLinkedNode(key,value);
            addNode(newNode);
            cache.put(key,newNode);
            size++;
            if (size>capability){
                moveTail();  //已经移除cache
                size--;
            }
        }else { //有节点了,直接修改值
            node.val=value;
            moveToHead(node);
        }
    }

    //先删除,在头部添加
    public void moveToHead(DLinkedNode node){
        deleteNode(node);
        addNode(node);
    }
    //添加节点移到头部
    public void addNode(DLinkedNode node){
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
        node.pre=head;
    }
    //删除
    public void deleteNode(DLinkedNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    //拿到尾巴(不是dummy尾巴),然后删除
    public void moveTail(){
        DLinkedNode actualTail=tail.pre;
        deleteNode(actualTail);
        cache.remove(actualTail.key);
    }

}