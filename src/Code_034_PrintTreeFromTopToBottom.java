import java.util.PriorityQueue;
import java.util.Queue;

public class Code_034_PrintTreeFromTopToBottom {
    //P171,面试题32 题目一 不分行从上到下打印二叉树
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    //用队列
    public static void printTreeFromTopToBottom(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }
}
