public class Code_027_MergeSortedList {
    //P145,面试题25 合并两个配虚的链表
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node mergeList(Node head1, Node head2){
        //此处考虑到两个链表中有一个为空或者两个均为空的情况
        if(head1 == null){
            return head2;
        }else{
            if(head2 == null){
                return head1;
            }
        }
        Node newHead;
        if(head1.value > head2.value){
            newHead = head2;
            head2 = head2.next;
        }else{
            newHead = head1;
            head1 = head1.next;
        }
        Node cur = newHead;
        while(head1 != null && head2!= null){
            if(head1.value > head2.value){
                cur.next = head2;
                head2 = head2.next;
            }else{
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        while(head1 != null){
            cur.next = head1;
            head1 = head1.next;
        }
        while(head2 != null){
            cur.next = head2;
            head2 = head2.next;
        }
        return newHead;
    }

    public static void printList(Node head){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node[] list1 = new Node[5];
        for(int i = 1; i < 6; i++){
            list1[i - 1] = new Node(2*i - 1);
            if(i > 1){
                list1[i - 2].next = list1[i - 1];
            }
        }
        Node[] list2 = new Node[5];
        for(int i = 1; i < 6; i++){
            list2[i - 1] = new Node(2*i);
            if(i > 1){
                list2[i - 2].next = list2[i - 1];
            }
        }
        printList(list1[0]);
        printList(list2[0]);
        printList(mergeList(list1[0], list2[0]));
    }
}
