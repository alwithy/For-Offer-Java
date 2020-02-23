public class Code_075_MaximalProfit {
    //P304, 面试题63 股票的最大利润
    public static int maxDiff(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new RuntimeException("Invalid input!");
        }

        //使用min变量保存数组前i - 1个数字中的最小值
        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 2; i < arr.length; i++) {
            min = Math.min(min, arr[i - 1]);
            maxDiff = Math.max(maxDiff, arr[i] - min);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(arr));
    }
}
