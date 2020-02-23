public class Code_074_LastNumInCircle {
    //P300, 面试题62 圆圈中最后剩下的数字
    public static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //方法一，循环链表模拟
    public static int lastRemain1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        //生成循环链表
        Node head = new Node(0);
        Node current = head;
        for (int i = 1; i < n ; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        current.next = head;

        //time为计数器，每删去一次节点后time+1
        int time = 0;
        while (time < n - 1) {
            head = deleteNode(head, m);
            time++;
        }

        return head.value;
    }

    public static Node deleteNode(Node head, int m) {
        if (m == 1) {
            Node current = head.next;
            while (current.next != head) {
                current = current.next;
            }
            //此时current为尾节点
            current.next = head.next;
            return head.next;
        }
        Node before = head;
        Node current = head.next;
        int i = 2;
        while (i < m) {
            before = current;
            current = before.next;
            i++;
        }
        //此时的current就是要删除的节点
        before.next = current.next;
        return current.next;
    }

    public static int lastRemain2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(lastRemain1(3,2));
        System.out.println(lastRemain1(3,1));
        System.out.println(lastRemain1(5,3));
    }
}
