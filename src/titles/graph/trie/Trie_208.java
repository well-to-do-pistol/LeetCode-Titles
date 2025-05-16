package titles.graph.trie;

public class Trie_208 {
    
}
class Trie {
    class TNode{
        TNode[] tnodes;
        boolean end;  // 区分前缀和单词
        TNode(){
            tnodes = new TNode[26];
        }
    }
    TNode f;
    public Trie() {
        f = new TNode();
    }
    
    public void insert(String word) {
        TNode cur = f;
        for (char c : word.toCharArray()){
            if(cur.tnodes[c-'a']==null){            // 如果空就new,不空就继续走
                cur.tnodes[c-'a'] = new TNode();   
            }
            cur = cur.tnodes[c-'a'];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        TNode cur = f;
        for (char c : word.toCharArray()){
            if(cur.tnodes[c-'a']==null){
                return false;
            }
            cur = cur.tnodes[c-'a'];
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        TNode cur = f;
        for (char c : prefix.toCharArray()){
            if(cur.tnodes[c-'a']==null){
                return false;
            }
            cur = cur.tnodes[c-'a'];
        }
        return true;
    }
}