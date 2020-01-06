public class Code_037_SequenceOfBST {
    //P179,面试题33 二叉搜索树的后序遍历序列
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node (int value) {
            this.value = value;
        }
    }

    //使用递归判断
    public static boolean isSequenceOfBST (int[] arr, int begin, int end) {
        //此处认为只有一个节点的不属于搜索二叉树
        if (arr == null || arr.length <= 1 || end < begin) {
            return false;
        }

        //排除了只有一个节点的树之后，如果begin == end, 说明子树只有一个节点
        if (begin == end) {
            return true;
        }
        //arr[end] 为根节点值
        int i = begin;
        //找到右子树第一个元素
        for (; i < end; i++) {
            if (arr[i] > arr[end]) {
                break;
            }
        }

        //判断右子树所有元素是不是都比根节点的大，不是则说明不是搜索二叉树
        for (int j = i; j < end; j++) {
            if (arr[j] <= arr[end]) {
                return false;
            }
        }

        boolean left = true;
        //左子树存在则递归判断左子树是否满足条件
        if (i - 1 >= begin) {
            left = isSequenceOfBST(arr, begin, i - 1);
        }

        boolean right = true;
        //右子树存在则判断右子树
        if (i <= end - 1) {
            right = isSequenceOfBST(arr, i, end - 1);
        }

        return left && right;
    }

    public static void main(String[] args) {
        int[] arr = {7,4,6,5};
        boolean isBST = isSequenceOfBST(arr, 0, arr.length - 1);
        System.out.println(isBST);
    }
}
