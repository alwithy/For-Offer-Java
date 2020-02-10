public class Code_062_TreeDepth {
    //P271, 面试题55 二叉树的深度
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public int findDepth(Node head) {
        if (head == null) {
            return 0;
        }
        return findDepthCore(head, 1);
    }

    private int findDepthCore(Node head, int depth) {
        int leftDepth = 0;
        int rightDepth = 0;

        if (head.left != null) {
            leftDepth = findDepthCore
                    (head.left, depth + 1);
        }
        if (head.right != null) {
            rightDepth = findDepthCore
                    (head.right, depth + 1);
        }

        return max(depth, leftDepth, rightDepth);
    }

    public static int max(int a, int b, int c) {
        int res = Math.max(a, b);
        res = Math.max(res, c);
        return res;
    }
}
