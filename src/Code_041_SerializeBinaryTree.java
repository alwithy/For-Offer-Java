import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Code_041_SerializeBinaryTree {
    //P194,面试题37 序列化二叉树
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    //用前序遍历的顺序序列化
    public static String serializeByPre(Node head) {
        if (head == null) {
            return "$,";
        }
        String res = head.value + ",";
        res += serializeByPre(head.left);
        res += serializeByPre(head.right);
        return res;
    }

    //用前序遍历顺序序列化得到的字符串重建二叉树
    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(values));
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("$")) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
