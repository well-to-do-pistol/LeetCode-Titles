package year1.month1.week2.day1;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.Stack;

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
        if (t!=null)t.fa=s;    //就算t为空也不能返回,先连上.注意!!!这句一定要在最前面,有父先确定父子
        if (s==null || s==t)return;
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
        if (root==null || node==null || root==node)return; //adjust会递归,一定要有边界判断
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
    //----------------------------------------------------------------------------------------------------
    Node getMin(Node node){
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
    void changeColor(Node a,Node b){
        Flag temp = a.flag;
        a.flag=b.flag;
        b.flag=temp;
    }
    void deleteAdjust(Node node){
        if (node==null || node==root)return; //边界
        if (node.flag==Flag.RED){            //1.红节点直接删除
            return;
        }

        Node p=node.fa;
        boolean dir=node==p.left;
        Node b=dir? p.right : p.left; //bro节点

        if (b.flag==Flag.RED){               //2.兄弟为红, pb互换,p向D(删除节点)转
            changeColor(p,b);
            linkReplace(p,b);                //b顶掉p
            link(p,dir? b.left:b.right, !dir);//如果dir,b在右,左旋(新根左放旧根右)
            link(b,p,dir);                   //如果dir,b在右,那p放会b的左
            deleteAdjust(node);              //继续递归
            return;
        }

        Node broLeft=b.left;
        Node broRight=b.right;

        if (broLeft!=null && broLeft.flag==Flag.RED || broRight!=null && broRight.flag==Flag.RED){ //3.兄弟黑,至少有一个红孩
            if (dir){    //兄在右
                if (broLeft!=null && broLeft.flag==Flag.RED){ //左孩红或全红, r变p,p变黑,RL
                    broLeft.flag=p.flag;
                    p.flag=Flag.BLACK;
                    rotateRL(p);
                }else {   //其他情况, bp互换, r变黑, RR
                    changeColor(b,p);
                    if (broLeft != null) {
                        broLeft.flag=Flag.BLACK;
                    }
                    rotateRR(p);
                }
            }else {      //兄在左
                if (broRight!=null && broRight.flag==Flag.RED){ //右孩红或全红, r变p,p变黑,LR
                    broRight.flag=p.flag;
                    p.flag=Flag.BLACK;
                    rotateLR(p);
                }else {   //其他情况,bp互换,r变黑,LL
                    changeColor(b,p);
                    if (broRight!=null){
                        broRight.flag=Flag.BLACK;
                    }
                    rotateLL(p);
                }
            }
        }else { //兄弟无红孩, D变红, 递交b进行递归
            node.flag=Flag.RED;
            deleteAdjust(p);
        }
    }
    void delete(Node node){ //1.无孩调整删;2.单孩替换递归;3.双孩找后继递归
        if (node==null || root==null)return;
        if (node.left==null && node.right==null){
            deleteAdjust(node);
            linkReplace(node,null);
            return;                      //删除叶子节点,根不用作调整,有孩子的情况会在删除(叶子)之后作调整
        } else if (node.left!=null && node.right!=null) { //双孩找后继递归
            Node next=getMin(node.right);
            node.val=next.val;
            delete(next);
        }else {                         //单孩替换递归
            Node next=node.left==null? node.right : node.left;
            node.val=next.val;
            delete(next);
        }
        while (root.fa!=null)root=root.fa;//root可能被旋下来,一直往上更新根
    }
    //----------------------------------------------------------------------------------------------------
    void inOrder(){ //用cur记录一直向左的点(包括根),直到没有就pop,然后再找右(替换为cur),继续重复
        if (root==null)return;
        Stack<Node> stack = new Stack<>();
        Node cur=root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                Node temp=stack.pop();
                System.out.print(temp.val+" ");
                if (temp.right!=null)cur=temp.right;
            }
        }
        System.out.println();
    }
    private void printHelper(Node root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.flag == Flag.RED ? "RED" : "BLACK";
            System.out.println(root.val + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }
    public void printTree() {
        if (root != null) {
            printHelper(root, "", true);
        }
    }

    public static void main(String[] args) {
        RedBlackTree_C tree = new RedBlackTree_C();
        tree.insert(-10);
        tree.insert(-3);
        tree.insert(0);
        tree.insert(5);
        tree.insert(9);
        tree.inOrder();
        tree.printTree();
        tree.delete(tree.find(tree.root, -3));
        tree.inOrder();
        tree.delete(tree.find(tree.root, 0));
        tree.inOrder();
    }
}
