package titles.binary_tree.bst.avl;

//左旋:新根的左放旧根的右
//右旋:新根的右放旧根的左

import java.util.Random;

class Node{
    int val,height;
    Node left,right;
    public Node(int val){
        this.val=val;
        height=1;
    }
}
class AVLT{
    Node root;
    int height(Node node){
        return (node==null) ? 0 : node.height;
    }
    void updateHeight(Node node){
        node.height = Math.max(height(node.left), height(node.right))+1;
    }
    int getBalance(Node node){
        return (node==null) ? 0 : height(node.left)- height(node.right);
    }
    Node rotateRight(Node y){
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;                //先更新被埋在下面的, 再更新甩在上面的
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    Node rotateLeft(Node y){
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    void insert(int key){
        root = insert(root,key);
    }
    Node insert(Node node, int key){
        if(node==null)return  new Node(key);

        if(key < node.val){
            node.left = insert(node.left, key);
        }else if(key > node.val){
            node.right = insert(node.right,key);
        }else
            return node; //不允许重复

        updateHeight(node); //记得要先更新高度(插一个, 更新一个高度)

        int balance = getBalance(node);
        if(balance > 1 && getBalance(node.left)>0){
            return rotateRight(node);
        } else if (balance < -1 && getBalance(node.right)<0) {
            return rotateLeft(node);
        } else if (balance > 1 && getBalance(node.left)<0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if (balance < -1 && getBalance(node.right)>0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    Node minValueNode(Node node){
        Node cur = node;
        while (cur.left!=null){
            cur = cur.left;
        }
        return cur;
    }
    void delete(int key){
        root = delete(root, key);
    }
    Node delete(Node node, int key){
        if(node==null) return null;
        if(key < node.val){
            node.left = delete(node.left,key);
        }else if (key > node.val){
            node.right = delete(node.right, key);
        }else {
            if(node.left==null || node.right==null){
                node = (node.left==null) ? node.right : node.left;
            }else {
                Node tmp = minValueNode(node.right);
                node.val = tmp.val;
                node.right = delete(node.right, tmp.val); //不只删除还要=连接
            }
        }
        if(node==null)return null;
        updateHeight(node);
        int balance = getBalance(node);
        if(balance > 1 && getBalance(node.left)>=0){
            return rotateRight(node);
        } else if (balance < -1 && getBalance(node.right)<=0) {
            return rotateLeft(node);
        } else if (balance > 1 && getBalance(node.left)<0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if (balance < -1 && getBalance(node.right)>0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    // 先判断是否二叉搜索, 再判断是否平衡
    boolean validateAVLBST(Node node) {
        if (node == null)
            return true;
        if (node.left != null && node.val < node.left.val)
            return false;
        if (node.right != null && node.val > node.right.val)
            return false;
        if (getBalance(node) > 1 || getBalance(node) < -1)
            return false;
        return validateAVLBST(node.left) && validateAVLBST(node.right);
    }

    void preOrder(Node node){
        if (node!=null){
            System.out.print(node.val+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
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

//            String sColor = root.flag == RedBlackTree_C.Flag.RED ? "RED" : "BLACK";
            System.out.println(root.val);
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }
    public void printTree() {
        if (root != null) {
            printHelper(root, "", true);
        }
    }
    void check(){
        preOrder(root);
        System.out.println();
        printTree();
        // 极短的暂停 (1 纳秒).  注意：这仍然可能比您预期的要长，
        // 因为 Thread.sleep() 的精度有限，并且受到操作系统调度程序的影响。
        try {
            Thread.sleep( 100, 0); // 0 毫秒 + 1 纳秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int j=0; j<100; ++j) {
            AVLT tree = new AVLT();
            for (int i = 0; i < 10000; i++) {
                int value = rand.nextInt(10000) + 1; // Random value between 1 and 10000
                tree.insert(value);
                tree.check();
                if (!tree.validateAVLBST(tree.root)) {
                    System.out.println("Tree is unbalanced after inserting " + value);
                    break;
                }
            }
            for (int i = 0; i < 10000; i++) {
                int value = rand.nextInt(10000) + 1; // Random value between 1 and 10000
                tree.delete(value);
                tree.check();
                if (!tree.validateAVLBST(tree.root)) {
                    System.out.println("Tree is unbalanced after inserting " + value);
                    break;
                }
            }
        }
    }
/* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
}
