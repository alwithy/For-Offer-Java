public class Code_063_BalancedBinaryTree {
    //P273, 面试题55 问题2 平衡二叉树
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    static class ReturnData {
        int depth;
        boolean isBalanced;
        public ReturnData(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }

    public static boolean isBalanced(Node head) {
        return isBalancedcore(head).isBalanced;
    }

    private static ReturnData isBalancedcore(Node head) {
        if (head == null) {
            return new ReturnData(0, true);
        }

        //使用后序遍历
        int left = 0;
        int right = 0;
        if (isBalancedcore(head.left).isBalanced
            && isBalancedcore(head.right).isBalanced) {
            left = isBalancedcore(head.left).depth;
            right = isBalancedcore(head.right).depth;
            int diff = left - right;
            if (diff >= -1 && diff <= 1) {
                int depth = 1 + Math.max(left, right);
                return new ReturnData(depth, true);
            }
        }
        return new ReturnData(0, false);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalanced(head));
    }
}
