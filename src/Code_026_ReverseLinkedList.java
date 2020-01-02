public class Code_026_ReverseLinkedList {
    //P142,面试题24 反转链表
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node reverseList(Node head) {
        if (head == null && head.next == null) {
            return null;
        }
        Node cur = head;
        Node prv = null;
        Node next;
        Node newHead = null;
        while (cur != null) {
            if (cur.next == null) {
                newHead = cur;
            }
            next = cur.next;
            cur.next = prv;

            prv = cur;
            cur = next;
        }
        return newHead;
    }

    //打印链表的函数，用于测试
    public static void printList(Node head){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node[] list = new Node[10];
        for(int i = 0; i < 10; i++){
            list[i] = new Node(i);
            if(i > 0){
                list[i - 1].next = list[i];
            }
        }
        printList(list[0]);
        printList(reverseList(list[0]));
    }
}
