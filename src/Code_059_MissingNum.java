public class Code_059_MissingNum {
    //P266, 面试题53 题目2 0~n-1中缺失的数字
    public static int getMissingNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Invalid input!");
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = start + ((end - start) >> 1);
        while (end >= start) {
            if (arr[mid] != mid) {
                if (mid == 0 || arr[mid - 1] == mid - 1) {
                    return mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + ((end - start) >> 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5, 6};
        System.out.println(getMissingNum(arr));
    }
}
