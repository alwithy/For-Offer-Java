public class Code_040_ConvertBinarySearchTree {
    //P191,面试题36 二叉搜索树转化为双向链表
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node convertTree(Node head) {
        if (head == null) {
            return null;
        }
        Node headOfList = convertTreeCore(head);
        while (headOfList.left != null) {
            headOfList = headOfList.left;
        }
        return headOfList;
    }

    //该函数返回值为链表的最后一个节点
    public static  Node convertTreeCore(Node head) {
        if (head == null) {
            return null;
        }
        //处理左子树
        Node cur = head.left;
        if (cur != null) {
            head.left = convertTreeCore(cur);
            head.left.right = head;
        }
        //处理右子树
        cur = head.right;
        Node lastNode = head;
        if (cur != null) {
            //首先找到右子树的左边界
            while (cur.left != null) {
                cur = cur.left;
            }
            lastNode = convertTreeCore(head.right);
            head.right = cur;
            cur.left = head;
        }
        return lastNode;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.right;
        }
    }

    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n8 = new Node(8);
        Node n10 = new Node(10);
        Node n14 = new Node(14);
        Node n12 = new Node(12);
        Node n16 = new Node(16);
        n6.left = n4;
        n6.right = n8;
        n10.left = n6;
        n10.right = n14;
        n14.left = n12;
        n14.right = n16;
        printList(convertTree(n10));
    }

}
