package titles.binary_tree.bst.avl.KthSmallest_230;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KthSmallest_230_2 {
}

// 3. 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第k小的值，你将如何优化算法？
// 平衡二叉树
class Solution_ {
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历生成数值列表
        List<Integer> inorderList = new ArrayList<Integer>();
        inorder(root, inorderList);

        // 构造平衡二叉搜索树
        AVLT avl = new AVLT(inorderList);

        // 模拟1000次插入和删除操作
        int[] randomNums = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; ++i) {
            randomNums[i] = random.nextInt(10001);
            avl.insert(randomNums[i]);
        }
        shuffle(randomNums); // 列表乱序
        for (int i = 0; i < 1000; ++i) {
            avl.delete(randomNums[i]);
        }
        return avl.kthSmallest(k);
    }

    private void inorder(TreeNode node, List<Integer> inorderList) {
        if (node.left != null) {
            inorder(node.left, inorderList);
        }
        inorderList.add(node.val);
        if (node.right != null) {
            inorder(node.right, inorderList);
        }
    }

    private void shuffle(int[] arr) {
        Random random = new Random();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int randIndex = random.nextInt(length);
            int temp = arr[i];
            arr[i] = arr[randIndex];
            arr[randIndex] = temp;
        }
    }
}

class AVLT{
    class Node{
        int val,height,size;
        Node left,right;
        public Node(int val){
            this.val=val;
            height=1;
            size=1;
        }
    }
    Node root;
    int height(Node node){
        return (node==null) ? 0 : node.height;
    }
    int size(Node node){
        return (node==null) ? 0 : node.size;
    }
    void updateHeightSize(Node node){
        node.height = Math.max(height(node.left), height(node.right))+1;
        node.size = size(node.left)+size(node.right)+1;
    }
    int getBalance(Node node){
        return (node==null) ? 0 : height(node.left)- height(node.right);
    }
    Node rotateRight(Node y){
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;                //先更新被埋在下面的, 再更新甩在上面的
        updateHeightSize(y);
        updateHeightSize(x);
        return x;
    }
    Node rotateLeft(Node y){
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        updateHeightSize(y);
        updateHeightSize(x);
        return x;
    }
    void insert(int key){
        root = insert(root,key);
    }
    Node insert(Node node, int key){
        if(node==null)return  new Node(key);

        if(key <= node.val){    //允许重复
            node.left = insert(node.left, key);
        }else if(key > node.val)
            node.right = insert(node.right,key);

        updateHeightSize(node); //记得要先更新高度(插一个, 更新一个高度)

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
        updateHeightSize(node);
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

//--------------------------------------- kthSmallest ------------------------------------------------

    public AVLT(){}
    public AVLT(List<Integer> vals) {
        if (vals != null) {
            this.root = build(vals, 0, vals.size() - 1);
        }
    }

    // 根据vals[l:r]构造平衡二叉搜索树 -> 返回根结点
    private Node build(List<Integer> vals, int l, int r) {
        int m = (l + r) >> 1;
        Node node = new Node(vals.get(m));
        if (l <= m - 1) {
            node.left = build(vals, l, m - 1);
        }
        if (m + 1 <= r) {
            node.right = build(vals, m + 1, r);
        }
        updateHeightSize(node);
        return node;
    }

    public int kthSmallest(int k) {
        Node node = root;
        while (node != null) {
            int left = size(node.left);
            if (left < k - 1) {
                node = node.right;
                k -= left + 1;
            } else if (left == k - 1) {
                break;
            } else {
                node = node.left;
            }
        }
        return node.val;
    }

//--------------------------------------- kthSmallest ------------------------------------------------
//--------------------------------------- valid AVL --------------------------------------------------

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

    public static void shuffle(int[] arr) {
        Random random = new Random();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int randIndex = random.nextInt(length);
            int temp = arr[i];
            arr[i] = arr[randIndex];
            arr[randIndex] = temp;
        }
    }

//--------------------------------------- valid AVL --------------------------------------------------

    public static void main(String[] args) {
//        Random rand = new Random();
//        for (int j=0; j<100; ++j) {
//            AVLT tree = new AVLT();
//            int[] randomNums = new int[100];
//            for (int i = 0; i < 100; i++) {
//                int value = rand.nextInt(100001); // Random value between 1 and 100000
//                randomNums[i] = value;
//                tree.insert(value);
//                tree.check();
//                if (!tree.validateAVLBST(tree.root)) {
//                    System.out.println("Tree is unbalanced after inserting " + value);
//                    break;
//                }
//            }
//            shuffle(randomNums); // 列表乱序
//            for (int i = 0; i < 100; i++) {
//                int value = randomNums[i];
//                tree.delete(value);
//                tree.check();
//                if (!tree.validateAVLBST(tree.root)) {
//                    System.out.println("Tree is unbalanced after inserting " + value);
//                    break;
//                }
//            }
//        }

        for (int i=0; i<100; ++i){
            Solution_ solution = new Solution_();
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
            TreeNode node6 = new TreeNode(6);
            node5.left=node3;
            node5.right=node6;
            node3.left=node2;
            node3.right=node4;
            node2.left=node1;
            System.out.println(solution.kthSmallest(node5,3));
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
