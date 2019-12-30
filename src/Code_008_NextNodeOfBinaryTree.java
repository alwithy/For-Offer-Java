public class Code_008_NextNodeOfBinaryTree {
    //P65面试题8:中序遍历的下一个节点
    public static class Node{
        int value;
        Node left;
        Node right;
        Node father;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node getNext(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else{
            while(node.father != null){
                if(node.father.left == node) {
                    return node.father;
                }
                node = node.father;
            }
            return null;
        }
    }

}
