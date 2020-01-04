public class Code_028_SubtreeOfBinaryTree {
    //P148,面试题26 二叉树的子结构
    public static class Node{
        double value;
        Node left;
        Node right;
        public Node(double value){
            this.value = value;
        }
    }

    //递归判断
    public static boolean tree2IsSubtreeOfTree2(Node head1, Node head2){
        if(head2 == null){
            return true;
        }else if(head1 == null){
            return false;
        }

        boolean res = false;
        if(Double.valueOf(head1.value).equals(head2.value)){
            res = isSubtree(head1, head2);
        }
        if(!res){
            res = tree2IsSubtreeOfTree2(head1.left, head2);
        }
        if(!res){
            res = tree2IsSubtreeOfTree2(head1.right, head2);
        }
        return res;
    }

    private static boolean isSubtree(Node head1, Node head2) {
        if(head2 == null){
            return true;
        }
        if(head1 == null){
            return false;
        }

        return Double.valueOf(head1.value).equals(head2.value) &&
                isSubtree(head1.left, head2.left) &&
                isSubtree(head1.right, head2.right);
    }
}
