public class Code_038_PathInTree {
    //P182,面试题34 二叉树中和为某值的路径
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node (int value) {
            this.value = value;
        }
    }

    //此处没规定节点值不能为负值，所以每一条路都要走到叶节点才能判断
    //使用StringBuilder实现
    public static void findPath(Node head, int expectedSum) {
        if (head == null) {
            return;
        }

        StringBuilder path = new StringBuilder(head.value + " ");
        findPathCore(head.left, expectedSum, head.value, path);
        findPathCore(head.right, expectedSum, head.value, path);
    }

    public static void findPathCore(Node head, int expectedSum,
                                    int sum, StringBuilder path) {

        //记录下上一个节点时path的长度，便于之后删除这个节点给path添加的内容
        int fatherNodePath = path.length();
        sum = sum + head.value;
        path.append(head.value).append(" ");
        int thisNodePath = path.length();


        //当来到叶节点时
        if (head.left == null && head.right == null) {
            if (sum == expectedSum) {
                System.out.print("A path is found : ");
                System.out.println(path);
            }
        } else {
            if (head.left != null) {
                findPathCore(head.left, expectedSum, sum, path);
            }

            if (head.right != null) {
                findPathCore(head.right, expectedSum, sum, path);
            }
        }

        //返回上一个节点前，删除这个节点添加的内容
        path.delete(fatherNodePath, thisNodePath);
    }

    public static void main(String[] args) {
        Node[] tree = new Node[5];
        tree[0] = new Node(10);
        tree[1] = new Node(5);
        tree[2] = new Node(12);
        tree[3] = new Node(4);
        tree[4] = new Node(7);
        tree[0].left = tree[1];
        tree[0].right = tree[2];
        tree[1].left = tree[3];
        tree[1].right = tree[4];
        findPath(tree[0], 22);
    }
}
