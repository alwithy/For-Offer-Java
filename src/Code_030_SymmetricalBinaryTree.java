import java.util.LinkedList;
import java.util.Queue;

public class Code_030_SymmetricalBinaryTree {
    //P159,面试题28 判断是否是对称二叉树
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    //使用类似前序遍历的方法判断
    public static boolean isSymmetricalBinaryTree(Node head){
        return isSymmetricalBinaryTree(head, head);
    }

    private static boolean isSymmetricalBinaryTree(Node head1, Node head2) {
        if(head1 == null && head2 == null){
            return true;
        }
        if(head1 == null || head2 == null){
            return false;
        }
        if(head1.value != head2.value){
            return false;
        }
        return isSymmetricalBinaryTree(head1.left, head2.right) &&
                isSymmetricalBinaryTree(head1.right, head2.left);
    }
}
