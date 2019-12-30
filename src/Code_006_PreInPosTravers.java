import java.util.Stack;

public class Code_006_PreInPosTravers {
    //二叉树的前序，中序，后序遍历的非递归实现
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int data){
            this.value = data;
        }
    }

    //前序遍历非递归
    public static void preOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println("前序遍历：");
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.value);
            if(head.right != null){
                stack.push(head.left);
            }
            if(head.left != null){
                stack.push(head.right);
            }
        }
        System.out.println("");
    }

    //中序遍历非递归
    public static void inOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println("中序遍历：");
        Stack<Node> stack = new Stack<Node>();
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                System.out.println(head.value + " ");
                head = head.right;
            }
        }
        System.out.println("");
    }

    //后序遍历非递归
    public static void posOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println("后序遍历：");
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(head);
        while(!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if(head.left != null){
                s2.push(head.left);
            }
            if(head.right != null){
                s2.push(head.right);
            }
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().value + " ");
        }
        System.out.println("");
    }
}
