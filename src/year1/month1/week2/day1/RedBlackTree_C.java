package year1.month1.week2.day1;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

public class RedBlackTree_C {
    private static final boolean isMultiMap=false;
    enum Flag{
        RED,BLACK
    }
    class Node{
        int val;
        Flag flag;
        Node fa,left,right;
        public Node(int val){
            this.val=val;
            flag=Flag.RED;
        }
    }
    private Node root;
    Node find(Node root, int val){
        while (root!=null){
            if (val<root.val)
                root=root.left;
            else if (val>root.val)
                root=root.right;
            else return root;
        }
        return null;
    }

    //插入并且连接
    void insertAndLink(Node root, Node node){
        if (node.val<root.val){
            if (root.left!=null)
                insertAndLink(root.left,node);
            else{
                root.left=node;
                node.fa=root;
            }

        } else {
            if (root.right !=null)
                insertAndLink(root.right,node);
            else {
                root.right=node;
                node.fa=root;
            }
        }
    }

    //连接父子关系, dir为true则为左
    void link(Node s, Node t, boolean dir){
        if (s==null || s==t)return;

        if (t!=null)t.fa=s;    //就算t为空也不能返回,先连上
        if (dir)
            s.left=t;
        else
            s.right=t;
    }

    void linkLeft(Node s, Node t){
        link(s,t,true);
    }
    void linkRight(Node s,Node t){
        link(s,t,false);
    }
    void linkReplace(Node s,Node t){
        link(s.fa,t,s.fa!=null && s.fa.left==s);
    }
    void rotateLL(Node root){ //右旋:新根右放旧根左
        Node c1=root.left;
        linkReplace(root,c1); //c1顶掉root
        linkLeft(root,c1.right);   //新根右放旧根左
        linkRight(c1,root);       //旧根放右
    }
    void rotateRR(Node root){ //左旋:新根左放旧根右
        Node c1=root.right;
        linkReplace(root,c1); //c1顶掉root
        linkRight(root,c1.left);   //新根左放旧根右
        linkLeft(c1,root);       //旧根放左
    }
    void rotateLR(Node root){
        Node c1=root.left;   //先左旋
        Node c2=c1.right;
        linkLeft(root,c2);
        linkRight(c1,c2.left);
        linkLeft(c2,c1);
        rotateRR(root);
    }
    void rotateRL(Node root){
        Node c1=root.right;   //先右旋
        Node c2=c1.left;
        linkRight(root,c2);
        linkLeft(c1,c2.right);
        linkRight(c2,c1);
        rotateLL(root);
    }
    void rotate(Node pp, Node p, Node node){
        if (pp.left==p){
            if (p.left==node)
                rotateLL(pp);
            else
                rotateLR(pp);
        } else if (pp.right==p) {
            if (p.right==node)
                rotateRR(pp);
            else
                rotateRL(pp);
        }
    }
    void adjust(Node node){
        Node p=node.fa;
        if (p==root)   //1.父根,黑
            p.flag=Flag.BLACK;
        if (p.flag==Flag.BLACK)return;

        Node pp=p.fa;
        Node unc= pp.left==p ? pp.right : pp.left;
        if (unc!=null && unc.flag==Flag.RED){  //2.叔红, 直接变色
            pp.flag=Flag.RED;
            unc.flag=Flag.BLACK;
            p.flag=Flag.BLACK;
            adjust(pp); //将pp提交上去继续递归
            return;
        }

        rotate(pp,p,node);  //3.叔无, 祖父红, 祖父的父黑(因为祖父的父已经不知道是谁了)
        pp.flag=Flag.RED;
        if (pp.fa!=null)pp.fa.flag=Flag.BLACK;
    }
    void insert(Node node){ //点
        if (node==null)return;
        if (root==null){
            root=node;
            node.flag=Flag.BLACK;
            return;
        }
        if (root==node)return;
        insertAndLink(root,node);
        adjust(node);
        while (root.fa != null)root=root.fa; //更新root, 可能被旋下来了, 一直更新
    }
    void insert(int val){  //值
        Node node=find(root,val);
        if (!isMultiMap && node!=null)return;
        insert(new Node(val));
    }
}
