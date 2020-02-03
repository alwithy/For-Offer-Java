public class Code_056_InversePairs {
    //P249,面试题51 数组中的逆序对
    public static int inversePairs(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        int res = inversePairsCore(arr, copy, 0, arr.length - 1);
        return res;
    }

    private static int inversePairsCore(int[] arr, int[] copy,
                                        int start, int end) {
        if (start == end) {
            copy[start] = arr[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = inversePairsCore(copy, arr,
                start, start + length);
        int right = inversePairsCore(copy, arr,
                start + length + 1, end);

        //i为前半段最后一个数字
        int i = start + length;
        //j为后半段最后一个数字
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length) {
            if (arr[i] > arr[j]) {
                copy[indexCopy--] = arr[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = arr[j--];
            }
        }
        while (i >= start) {
            copy[indexCopy--] = arr[i--];
        }
        while (j >= start + length + 1) {
            copy[indexCopy--] = arr[j--];
        }
        return left + right + count;
    }

    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        System.out.println(inversePairs(arr));
    }
}
