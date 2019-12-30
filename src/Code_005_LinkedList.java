import java.util.Stack;

public class Code_005_LinkedList {
    //实现单链表以及在链表末尾增加元素的功能
    public static class Node{
        public int value;
        public Node next;
        private Stack<Integer> stack;

        public Node(int value){
            this.value = value;
        }

        public Node add(Node node,int value){
            Node newNode = new Node(value);
            if(node.next == null){
                node.next = newNode;
            }else{
                Node last = node;
                while(last.next != null){
                    last = last.next;
                }
                last.next = newNode;
            }
            return newNode;
        }

        //P58，面试题6，从尾到头打印链表
        public void reversePrint(){
            if(this.next == null){
                p(this);
            }else{
                stack = new Stack<Integer>();
                Node cur = this;
                while(cur != null){
                    stack.push(cur.value);
                    cur = cur.next;
                }
                while(!stack.isEmpty()){
                    p(stack.pop());
                }
            }

        }

        public void p(Node node){
            System.out.println(node.value);
        }
        public void p(int value){
            System.out.println(value);
        }
    }

    public static void main(String[] args){
        Node first = new Node(0);
        if(first.next == null){
            System.out.println("node.next is null");
        }
        Node cur = first;
        for(int i = 1; i < 10; i++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        first.reversePrint();
    }
}
