package year1.month1.week2.day1;

public class RedBlackTree_C {
    enum Flag{
        RED,BLACK
    }
    class Node {
        int val;
        Flag flag;
        Node fa,left,right;
        Node(int val){
            this.val=val;
            this.flag=Flag.RED;
        }
    }
    private Node root;
    private Node find(Node root, int val){
        while (root!=null){
            if (val< root.val)
                root=root.left;
            else if (val> root.val)
                root=root.right;
            else
                return root;
        }
        return null;
    }
    //左旋:新根有左放旧根右
    //右旋:新根有右放旧根左
    Node rightRotate(Node y){
        //四步走,改变x和y的高度
        Node x=y.left;
        Node T2=x.right;
        x.right=y;
        y.left=T2;
        return x;
    }
    Node leftRotate(Node y){
        //四步走,改变x和y的高度
        Node x=y.right;
        Node T2=x.left;
        x.left=y;
        y.right=T2;
        return x;
    }
    Node insert(Node node,int val){
        //正常插入
        if (node==null)return new Node(val);

        if (val<node.val)
            node.left=insert(node.left,val);
        else if (val>node.val)
            node.right=insert(node.right,val);
        else return node;

        return node;
    }
}
