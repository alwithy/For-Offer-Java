public class Code_019_DeleteNodeInLinkedList {
    //P119，面试题18,题目1 删除链表的节点
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static void deleteNode(Node head, Node toBeDeleted){
        if(head == null || toBeDeleted == null){
            return;
        }
        //要删除的节点不是尾结点
        if(toBeDeleted.next != null){
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        }else if(head == toBeDeleted){
            head = null;
        }else{
            while(head.next != toBeDeleted && head.next.next != null){
                head = head.next;
            }
            head.next = null;
        }
    }
}
