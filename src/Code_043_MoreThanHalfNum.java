public class Code_043_MoreThanHalfNum {
    //P205,面试题39 数组中出现次数超过一半的数字
    //方法1，基于Partition的算法
    public static int moreThanHalfNumByPar(int[] arr) {
        if (arr == null || arr.length <= 0) {
            throw new RuntimeException("Invalid input!");
        }
        int mid = arr.length >> 1;
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);
        //找到中位数
        while (index != mid) {
            if (index < mid) {
                start = index + 1;
                index = partition(arr, start, end);
            }
            if (index > mid) {
                end = index - 1;
                index = partition(arr, start, end);
            }
        }
        int res = arr[mid];
        if (checkMoreThanHalf(arr, res)) {
            return res;
        } else {
            return 0;
        }
    }

    public static boolean checkMoreThanHalf(int[] arr, int res) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == res) {
                times++;
            }
        }
        int half = arr.length >> 1;
        return times > half;
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

    public static int random (int start, int end) {
        return (int) ((end - start) * Math.random()) + start;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
