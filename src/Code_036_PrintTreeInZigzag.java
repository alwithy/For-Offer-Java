import java.util.Stack;

public class Code_036_PrintTreeInZigzag {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void printTreeInZigzag(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> odd = new Stack<>();
        Stack<Node> even = new Stack<>();
        odd.push(head);
        //这一行的节点数量
        int toBePrint = 1;
        //下一行的节点数量
        int nextLine = 0;
        //这一行的行数，用于判断是奇数还是偶数
        int line = 1;
        while (!(odd.isEmpty()) || !(even.isEmpty())) {
            if ((line & 1) == 1) {
                head = odd.pop();
                System.out.print(head.value + " ");
                toBePrint--;
                //奇数行左子树先入偶数行所用栈（下一行所用栈）
                if (head.left != null) {
                    even.push(head.left);
                    nextLine++;
                }
                if (head.right != null) {
                    even.push(head.right);
                    nextLine++;
                }
            } else {
                head = even.pop();
                System.out.print(head.value + " ");
                toBePrint--;
                //偶数行右子树先入奇数行所用栈（下一行所用栈）
                if (head.right != null) {
                    odd.push(head.right);
                    nextLine++;
                }
                if (head.left != null) {
                    odd.push(head.left);
                    nextLine++;
                }
            }

            //toBePrint == 0时，说明该换行
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextLine;
                nextLine = 0;
                line++;
            }
        }
    }

    public static void main(String[] args) {
        Node[] tree = new Node[7];
        for(int i = 1; i < 8; i++){
            tree[i - 1] = new Node(i);
        }
        tree[0].left = tree[1];
        tree[0].right = tree[2];
        tree[1].left = tree[3];
        tree[1].right = tree[4];
        tree[2].left = tree[5];
        tree[2].right = tree[6];
        printTreeInZigzag(tree[0]);
    }
}
