public class Code_050_TranslateNumToString {
    //P231,面试题46 把数字翻译成字符串
    public static int getTranslateCount(int num) {
        if (num < 0) {
            return 0;
        }
        char[] charOfNum = String.valueOf(num).toCharArray();
        return getTranslateCount(charOfNum);
    }

    private static int getTranslateCount(char[] charOfNum) {
        int length = charOfNum.length;
        int[] counts = new int[length];
        int count = 0;
        int digit1 = 0;
        int digit2 = 0;
        for (int i = length - 1; i >= 0; i--) {
            count = 0;
            if (i < length - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }
            if (i < length - 1) {
                digit1 = charOfNum[i] - '0';
                digit2 = charOfNum[i + 1] - '0';
                if (10 * digit1 + digit2 >= 10 &&
                10 * digit1 + digit2 <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void main(String[] args) {
        System.out.println(getTranslateCount(1));
        System.out.println(getTranslateCount(11));
        System.out.println(getTranslateCount(123));
        System.out.println(getTranslateCount(1234));
        System.out.println(getTranslateCount(1213));
    }
}
