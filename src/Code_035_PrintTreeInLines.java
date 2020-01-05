import java.util.PriorityQueue;
import java.util.Queue;

public class Code_035_PrintTreeInLines {
    //P174,面试题32 题目二 分行从上到下打印二叉树
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void printTreeFromTopToBottom(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(head);
        int toBePrint = 1;
        int nextLine = 0;
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            toBePrint--;
            if (head.left != null) {
                queue.add(head.left);
                nextLine++;
            }
            if (head.right != null) {
                queue.add(head.right);
                nextLine++;
            }
            if(toBePrint == 0) {
                System.out.println();
                toBePrint = nextLine;
                nextLine = 0;
            }
        }
    }
}
