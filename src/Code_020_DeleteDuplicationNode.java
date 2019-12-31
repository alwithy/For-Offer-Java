public class Code_020_DeleteDuplicationNode {
    //P122 面试题18,题目2 删除重复的节点
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node deleteDuplication(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node cur = head;
        Node pre = null;
        while(cur != null){
            boolean needDelete = false;
            if(cur.next != null && cur.value == cur.next.value){
                needDelete = true;
            }
            if(!needDelete){
                pre = cur;
                cur = cur.next;
            }else {
                int value = cur.value;
                //循环结束时，toBeDel指向第一个不用被删除的节点（可能为null）
                Node toBeDel = cur.next;
                while(toBeDel != null && toBeDel.value == value){
                    toBeDel = toBeDel.next;
                    cur.next = toBeDel;
                }
                //若需要删除的节点中包括头结点，则需要将头结点指针向后移动
                if(cur == head){
                    head = cur.next;
                }else{
                    pre.next = cur.next;
                }
            }
        }

        return head;
    }

}
