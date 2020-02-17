public class Code_069_LeftRotateString {
    //P286，面试题58 题目2 左旋转字符串

    public static String leftRotate(String str, int n) {
        if (str == null || str.length() < n) {
            return null;
        }
        String firstPart = str.substring(0, n);
        String secondPart = str.substring(n);
        return secondPart + firstPart;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(leftRotate(str, 0));
        System.out.println(leftRotate(str, 1));
        System.out.println(leftRotate(str, 2));
    }
}
