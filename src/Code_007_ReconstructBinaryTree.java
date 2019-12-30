import java.util.HashMap;
import java.util.Stack;

public class Code_007_ReconstructBinaryTree {


    //P62面试题7：重建二叉树
    public static  class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node construct(int[] pre, int[] in){
        if(pre == null || in == null){
            return null;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            hashMap.put(in[i], i);
        }
        return constructTree(pre, 0, pre.length -1,
                in, 0, in.length -1, 
                hashMap);
    }

    public static Node constructTree(int[] pre, int preStart, int preEnd,
                              int[] in, int inStart, int inEnd,
                              HashMap<Integer,Integer> hashMap){
        if(preEnd - preStart != inEnd - inStart){
            return null;
        }
        Node head = new Node(pre[preStart]);
        if(preStart == preEnd){
            return head;
        }
        int rootIndex = hashMap.get(head.value);
        //左右子树长度
        int leftTree = rootIndex - inStart;
        int rightTree = inEnd - rootIndex;
        if(leftTree > 0) {
            head.left = constructTree
                    (pre, preStart + 1,
                            preStart + leftTree,
                            in, inStart, rootIndex - 1,
                            hashMap);
        }
        if(rightTree > 0){
            head.right = constructTree
                    (pre, preStart + leftTree + 1,
                            preEnd,
                            in, rootIndex + 1, inEnd, hashMap);
        }
        return head;
    }
    //前序遍历非递归
    public static void preOrderUnRecur(Node head){
        System.out.println("前序遍历：");
        if(head !=null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //中序遍历非递归
    public static  void InOrderUnRecur(Node head){
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
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
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
                s1.push(head.left);
            }
            if(head.right != null){
                s1.push(head.right);
            }
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Node head = construct(pre, in);
        preOrderUnRecur(head);
        InOrderUnRecur(head);
        posOrderUnRecur(head);
    }
}
