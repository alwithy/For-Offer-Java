public class Code_024_FindKthNode {
    //P134，面试题22 链表中倒数第K个节点
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node findKthToTail(Node head, int k){
        if(head == null || k < 1){
            return null;
        }
        Node ahead = head;
        for(int i = 0; i < k; i++){
            if(ahead.next == null){
                return null;
            }
            ahead = ahead.next;
        }
        Node behind = head;
        while(ahead.next != null){
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }
}
