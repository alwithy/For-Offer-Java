public class Code_057_FirstCommonNodesInLists {
    //P253,面试题52 链表的第一个公共节点
    static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node firstCommonNode(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            throw new RuntimeException("Invalid input!");
        }
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        if (length1 > length2) {
            for (int i = length1 - length2; i > 0; i--) {
                head1 = head1.next;
            }
        } else if (length2 > length1) {
            for (int i = length2 - length1; i > 0; i--) {
                head2 = head2.next;
            }
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    private static int getLength(Node head) {
        if (head == null) {
            return 0;
        }
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}
