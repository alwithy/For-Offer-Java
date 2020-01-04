import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_029_MirrorOfBinaryTree {
    //P157,面试题27 二叉树的镜像
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    //递归
    public static void mirrorRecursively(Node head){
        if(head == null){
            return;
        }
        swap(head);
        mirrorRecursively(head.left);
        mirrorRecursively(head.right);
    }

    //层次遍历，用队列
    public static void mirrorWithQueue(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            swap(cur);

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    //前序遍历，用栈
    public static void mirrorWithStack(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            swap(head);

            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
    }

    public static void swap(Node head){
        if(head == null){
            return;
        }
        Node temp = head.left;
        head.left = head.right;
        head.right = temp;
    }

    public static void test(Node head){
        head = head.left;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node left = new Node(2);
        head.left = left;
        test(head);
        System.out.println(head.value);
    }
}
