package year1.month1.week2.day1;

import javax.xml.soap.Node;

public class Implement_Trie_prefix_tree_208 {
}
class Trie {
    //节点为Node, 26个字母对应指针类数组, 根据单词顺序利用字母数组分叉出树, 用isEnd来判断是否结尾(省去遍历)
    //类数组方便遍历

    Node strat;
    public static class Node{
        int isEnd=0;
        Node[] next;
        public Node() {
            next=new Node[26];
        }
    }
    public Trie() {
        strat=new Node();
    }

    public void insert(String word) {
        Node cur=this.strat;
        int n=word.length();
        for (int i=0; i<n; i++){
            char ch = word.charAt(i);
            int index=ch-'a';
            if (cur.next[index]==null){
                cur.next[index]=new Node();
            }
            cur=cur.next[index];
        }
        cur.isEnd=1; //最后设置isEnd
    }

    public boolean search(String word) {
        Node cur=this.strat;
        int n=word.length();
        for (int i=0; i<n; i++){
            char ch = word.charAt(i);
            int index=ch-'a';
            if (cur.next[index]==null){
                return false;
            }
            cur=cur.next[index];
        }
        return cur.isEnd==1;
    }

    public boolean startsWith(String prefix) {
        Node cur=this.strat;
        int n=prefix.length();
        for (int i=0; i<n; i++){
            char ch = prefix.charAt(i);
            int index=ch-'a';
            if (cur.next[index]==null){
                return false;
            }
            cur=cur.next[index];
        }
        return true;
    }
}