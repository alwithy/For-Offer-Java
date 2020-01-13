public class Code_044_KLeastNumbers {
    //P209,面试题40  输入整数数组，找出其中最小的k个数
    //方法1，基于Partition

    public static int[] kLeastNumByPartition(int[] arr, int k) {
        if (arr == null || arr.length <= 0) {
            throw new RuntimeException("Invalid input!");
        }
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(arr, start, end);
            } else {
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = arr[i];
        }
        return output;
    }




    public static int partition(int[] arr, int start, int end) {
        if (arr == null || start < 0 || end < 0 || end < start) {
            throw new RuntimeException("Invalid input!");
        }
        if (start == end) {
            return start;
        }
        int index = random(start, end);
        swap(arr, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                swap(arr, ++small, i);
            }
        }
        swap(arr, ++small, end);
        return small;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int random (int start, int end) {
        return (int) ((end - start) * Math.random()) + start;
    }

}
