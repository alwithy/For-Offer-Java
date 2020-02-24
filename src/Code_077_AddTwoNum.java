public class Code_077_AddTwoNum {
    //P310,面试题65 不用加减乘除法

    //使用位运算
    public static int add(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;

        while (carry != 0) {
            a = sum;
            b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(3,5));
    }
}
