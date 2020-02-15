public class Code_066_TwoNumWithSumS {
    //P280, 面试题57  题目1 和为S的两个数字
    static boolean haveFoundTwoNums = false;

    public static int[] findNumsWithSum(int[] arr, int sum) {
        if (arr == null || arr.length <= 1) {
            throw new RuntimeException("Invalid input!");
        }
        int ahead = arr.length - 1;
        int behind = 0;
        while (ahead > behind) {
            if (arr[ahead] + arr[behind] == sum) {
                break;
            } else if (arr[ahead] + arr[behind] > sum) {
                ahead--;
            } else if (arr[ahead] + arr[behind] < sum) {
                behind++;
            }
        }
        if (arr[ahead] + arr[behind] == sum) {
            haveFoundTwoNums = true;
            return new int[]{arr[ahead], arr[behind]};
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        int[] res = findNumsWithSum(arr, 15);
        System.out.println(haveFoundTwoNums);
        System.out.println(res[0] + " " + res[1]);
    }
}
