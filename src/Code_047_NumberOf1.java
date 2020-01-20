public class Code_047_NumberOf1 {
    //P221,面试题43 1~n中整数1出现的次数

    public static int numOf1(int n) {
        if (n <= 0) {
            return 0;
        }
        StringBuilder num = new StringBuilder(String.valueOf(n));
        return numOf1Core(num);
    }

    private static int numOf1Core(StringBuilder num) {
        if (num == null || num.charAt(0) < '0' || num.charAt(0) > '9') {
            return 0;
        }
        int first = num.charAt(0) - '0';
        if (num.length() == 1) {
            if (first > 0) {
                return 1;
            }else {
                return 0;
            }
        }
        //numFirstDigit是第一位中1出现的数目
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = powerBase10(num.length() - 1);
        } else if (first == 1) {
            numFirstDigit = Integer.parseInt(num.substring(1)) + 1;
        }
        int numOtherDigits =
                first * (num.length() - 1)
                        * powerBase10(num.length() - 2);
        int numRecursive =
                numOf1Core(new StringBuilder(num.substring(1)));

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    public static int powerBase10(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(numOf1(n));
        System.out.println(numOf1(100));
        System.out.println(numOf1(9));
    }
}
