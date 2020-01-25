public class Code_048_DigitsInSequence {
    //P225，面试题44 数字序列中的某一位数字
    public static int digitAtIndex(int n) {
        //从1位数开始找，找到序列中第n位数字对应的是几位数（1位数是0-9,2位数10-99）
        int digit = 0;
        int index = 0;
        while (index < n) {
            digit++;
            index += countOfIntegers(digit);
        }
        //此时index >= n,如果不相等的话，则说明n位数对应的是digit - 1位数
        int num = powerBase10(digit) - 1;
        while (index > n) {
            num--;
            index -= digit;
        }
        //若index = n, 则n对应的是数字num的最低位
        char[] arr;
        if (index == n) {
            arr = String.valueOf(num).toCharArray();
            return arr[arr.length - 1] - '0';
        }
        //若index < n,则n对应的是数字num + 1的某一位
        arr = String.valueOf(num + 1).toCharArray();
        int indexInNum = 0;
        while (index + indexInNum + 1 != n) {
            indexInNum++;
        }
        return arr[indexInNum] - '0';
    }

    //找到对应的digit位数占了序列的多少位，比如90个2位数占180位
    private static int countOfIntegers(int digit) {
        if (digit == 1) {
            return 10;
        } else {
            return (powerBase10(digit) - powerBase10(digit -1)) * digit;
        }
    }

    private static int powerBase10(int num) {
        int res = 1;
        for (int i = 0; i < num; i++) {
            res *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(11));
        System.out.println(digitAtIndex(10));
        System.out.println(digitAtIndex(12));
    }
}
