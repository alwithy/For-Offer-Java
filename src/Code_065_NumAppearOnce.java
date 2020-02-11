public class Code_065_NumAppearOnce {
    //P278,面试题56 题目2 数组中只出现一次的数字
    public static int numAppearOnce(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Invalid input!");
        }

        int[] bitSum = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = arr[i] & bitMask;
                if (bit != 0) {
                    bitSum[j]++;
                }
                bitMask = bitMask << 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res += bitSum[i] % 3;
        }
        return res;
    }
}
