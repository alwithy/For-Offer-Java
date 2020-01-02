public class Code_025_MeetingNode {
    //P139,面试题23 链表中环的入口节点
    public class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node entryNodeOfLoop(Node head){
        Node ahead = meetingNode(head);
        if(ahead == null){
            return null;
        }

        //找到环中节点个数
        int lengthOfLoop = 1;
        Node behind = ahead.next;
        while(behind != ahead){
            lengthOfLoop++;
            behind = behind.next;
        }

        //ahead先走n步，然后和behind一样每次走一步
        //两者相遇处即是入环点
        ahead = head;
        behind = head;
        for(int i = 0; i < lengthOfLoop; i++){
            ahead = ahead.next;
        }
        while(ahead != behind){
            ahead = ahead.next;
            behind = behind.next;
        }
        return ahead;
    }



    //双指针法判断是否有环，返回双指针相遇的节点
    public static Node meetingNode(Node head){
        if(head == null){
            return null;
        }

        Node ahead = head; //快指针
        Node behind = head; //慢指针

        while(ahead != null){
            ahead = ahead.next.next;
            behind = behind.next;
            if(ahead == behind){
                return ahead;
            }
        }
        return null;
    }
}
