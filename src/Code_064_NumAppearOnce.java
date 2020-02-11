public class Code_064_NumAppearOnce {
    //P275,面试题56 题目1 数组中只出现一次的两个数字
    public static int[] findNumAppearOnce(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int resultOfExclusiveOr = 0;
        for (int i = 0; i < arr.length; i++) {
            resultOfExclusiveOr ^= arr[i];
        }

        int indexOf1 = findFirstBitIs1(resultOfExclusiveOr);
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (bitIs1(indexOf1, arr[i])) {
                res[0] ^= arr[i];
            } else {
                res[1] ^= arr[i];
            }
        }

        return res;
    }

    private static int findFirstBitIs1(int num) {
        int index = 0;
        while (((num & 1) == 0) && index <= 32) {//int最多占32位
            num = num >> 1;
            index++;
        }
        return index;
    }

    private static boolean bitIs1(int index, int num) {
        num = num >> index;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 5, 6, 6, 5};
        int[] res = findNumAppearOnce(arr);
        System.out.println(res[0] + " " + res[1]);
    }
}
