public class Code_061_KthNodeInBST {
    //P269, 面试题54 二叉搜索树的第k大节点
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    //使用中序遍历
    public static Node kthNode(Node head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        return kthNodeCore(head, k);
    }

    private static Node kthNodeCore(Node head, int k) {
        Node res = null;

        if (head.left != null) {
            res = kthNodeCore(head.left, k);
        }
        if (res == null) {
            if (k == 1) {
                res = head;
            }
            k--;
        }

        if (res == null && head.right != null) {
            res = kthNodeCore(head.right, k);
        }
        return res;
    }
}
