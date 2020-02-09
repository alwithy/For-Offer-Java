public class Code_060_IntegerIdenticalToIndex {
    //P266, 面试题53 题目3 数组中数值和下表相等的元素
    public static int getNumEqualToIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = start + ((end - start) >> 1);
        while (end >= start) {
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + ((end - start) >> 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 3, 5};
        System.out.println(getNumEqualToIndex(arr));
    }
}
