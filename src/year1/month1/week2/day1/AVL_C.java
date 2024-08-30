package year1.month1.week2.day1;

//左旋:新根的左放旧根的右
//右旋:新根的右放旧根的左

class Node{
    int val,height;
    Node left,right;
    public Node(int val){
        this.val=val;
        height=1;
    }
}
public class AVL_C {
    Node root;
    int height(Node N){ //防止节点是空的情况, 不设置无法计算高度
        if (N==null)return 0;
        return N.height;
    }
    int max(int a,int b) {
        return Math.max(a, b);
    }

    Node rightRotate(Node y){
        //四步走, 更新x,y高度
        Node x=y.left;
        Node T2=x.right;
        x.right=y;
        //新根的右放旧根的左
        y.left=T2;

        x.height=max(height(x.left),height(x.right)) + 1; //这里的加1是没错的, 因为要加上自己
        y.height=max(height(y.left),height(y.right)) + 1;

        return x;
    }

    Node leftRotate(Node y){
        //四步走, 更新x,y高度
        Node x=y.right;
        Node T2=x.left;
        x.left=y;
        //新根的左放旧根的右
        y.right=T2;

        x.height=max(height(x.left),height(x.right)) + 1; //这里的加1是没错的, 因为要加上自己
        y.height=max(height(y.left),height(y.right)) + 1;

        return x;
    }

    int getBalance(Node N){ //计算平衡因子也要设置为函数, 否则无法计算空节点导致无法计算
        if (N==null)return 0;
        return height(N.left)-height(N.right);
    }

    Node insert(Node node, int val){

        //正常插入
        if (node==null)return new Node(val);

        if (val < node.val)
            node.left=insert(node.left,val); //node是指当前层节点, 设置node.left没错
        else if (val > node.val)
            node.right=insert(node.right,val);
        else
            return node; //要return node, 不然少一个节点了

        //先算高度
        node.height=max(height(node.left),height(node.right)) + 1 ;

        //算平衡因子
        int bla=getBalance(node);

        if (bla > 1 && val < node.left.val){
            return rightRotate(node);
        }
        if (bla < -1 && val > node.right.val){
            return leftRotate(node);
        }
        if (bla > 1 && val > node.left.val){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if (bla > 1 && val < node.right.val){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node node){
        if (node!=null){
            System.out.print(node.val+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVL_C tree = new AVL_C();

        tree.root=tree.insert(tree.root, 10);
        tree.root=tree.insert(tree.root, 20);
        tree.root=tree.insert(tree.root, 30);
        tree.root=tree.insert(tree.root, 40);
        tree.root=tree.insert(tree.root, 50);
        tree.root=tree.insert(tree.root, 25);

        System.out.println("Preorder traversal of constructed AVL tree is : ");
        tree.preOrder(tree.root);
    }
/* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
}
