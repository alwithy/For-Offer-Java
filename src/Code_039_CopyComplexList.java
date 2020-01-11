import java.util.HashMap;

public class Code_039_CopyComplexList {
    //P187,面试题35 复杂链表的复制
    public static class Node {
        int value;
        Node next;
        Node random;
        public Node(int value) {
            this.value = value;
        }
    }

    //方法1，先在大链表中复制，然后将大链表分为两个小链表
    public static Node copyList1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next;
        //复制next指针
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //复制random指针
        cur = head;
        Node curCopy;
        while (cur != null) {
            curCopy = cur.next;
            curCopy.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        Node newHead = head.next;
        //将大链表分成两个小链表
        cur = head;
        while (cur != null) {
            curCopy = cur.next;
            next = cur.next.next;
            cur.next = next;
            curCopy.next = next == null ? null : next.next;
            cur = next;
        }
        return newHead;
    }

    //用哈希表
    public static Node copyList2(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        //复制各个节点
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        Node newhead = map.get(head);
        //将复制的节点组成链表
        Node curCopy;
        cur = head;
        while (cur != null) {
            curCopy = map.get(cur);
            curCopy.next = map.get(cur.next);
            curCopy.random = cur.random == null ? null : map.get(cur.random);
            cur = cur.next;
        }
        return newhead;
    }
}
