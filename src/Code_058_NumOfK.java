public class Code_058_NumOfK {
    //P263,面试题53 题目1 在排序数组中查找数字
    public static int numOfK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int firstK = findFirstK(arr, k);
        int lastK = findLastK(arr, k);
        return firstK >= 0 && lastK >= 0 ?
                lastK - firstK + 1 : 0;
    }

    private static int findFirstK(int[] arr, int k) {
        if (arr[0] == k) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = start + ((end - start) >> 1);
        while (end >= start) {
            if (arr[mid] == k && arr[mid - 1] != k) {
                break;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else if (arr[mid] == k && arr[mid - 1] == k) {
                end = mid - 1;
            }
            mid = start + ((end - start) >> 1);
        }
        return arr[mid] == k ? mid : -1;
    }

    private static int findLastK(int[] arr, int k) {
        if (arr[arr.length - 1] == k) {
            return arr.length - 1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = start + ((end - start) >> 1);
        while (end >= start) {
            if (arr[mid] == k && arr[mid + 1] != k) {
                break;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else if (arr[mid] == k && arr[mid + 1] == k) {
                start = mid + 1;
            }
            mid = start + ((end - start) >> 1);
        }
        return arr[mid] == k ? mid : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,3,4};
        System.out.println(numOfK(arr,1));
        System.out.println(numOfK(arr,2));
        System.out.println(numOfK(arr,3));
        System.out.println(numOfK(arr,4));
        //System.out.println(NumOfK(arr,4));
    }
}
