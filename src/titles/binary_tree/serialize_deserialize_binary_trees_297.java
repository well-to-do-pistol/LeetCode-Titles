package titles.binary_tree;

public class serialize_deserialize_binary_trees_297 {
}
class Codec {
    // 先序遍历是能从字符串变过来的
    // 序列化：先序递归，用n记录空节点，直接传一个sb，不用返回（因为是引用数据类型）
    // 反序列化：用逗号分开，直接用数据遍历数组，index为全局变量
    // Encodes a tree to a single string.
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rserialize(root,sb);
        return sb.toString();
    }

    private void rserialize(TreeNode root, StringBuilder sb) {
        if (root==null) {
            sb.append("n,");
            return;
        }
        sb.append(root.val).append(",");
        rserialize(root.left,sb);
        rserialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        index = 0;
        return rdeserialize(nodes);
    }

    private TreeNode rdeserialize(String[] nodes) {
        if ("n".equals(nodes[index])) {
            ++index;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        root.left = rdeserialize(nodes);
        root.right = rdeserialize(nodes);
        return root;
    }
}