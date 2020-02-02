public class Code_053_UglyNumber {
    //P240, 面试题49 丑数
    public static int getUglyNum(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyArr = new int[index];
        uglyArr[0] = 1;
        int nextUglyIndex = 1;
        int multiply2 = 1;
        int multiply3 = 1;
        int multiply5 = 1;
        while (nextUglyIndex < index) {
            uglyArr[nextUglyIndex] = minNum(
                    2 * multiply2,
                    3 * multiply3,
                    5 * multiply5);
            while (2 * multiply2 <= uglyArr[nextUglyIndex]) {
                multiply2++;
            }
            while (3 * multiply3 <= uglyArr[nextUglyIndex]) {
                multiply3++;
            }
            while (5 * multiply5 <= uglyArr[nextUglyIndex]) {
                multiply5++;
            }
            nextUglyIndex ++;
        }
        return  uglyArr[index - 1];
    }

    public static int minNum(int a, int b, int c) {
        int res = Math.min(a, b);
        res = Math.min(res, c);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNum(1));
        System.out.println(getUglyNum(2));
        System.out.println(getUglyNum(3));
        System.out.println(getUglyNum(4));
        System.out.println(getUglyNum(5));
        System.out.println(getUglyNum(7));
        System.out.println(getUglyNum(1500));
    }
}
