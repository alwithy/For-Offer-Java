public class Code_046_GreatestSumOfSubarrays {
    //P218，面试题42 连续子数组的最大和
    //解法一，举例分析数组规律
    public static int findGreatestSum(int[] arr) {
        if (arr == null && arr.length <= 0) {
            throw new RuntimeException("Invalid input!");
        }
        int curSum = 0;
        int greatestSum = 0x80000000;//int类型的最小值
        for (int i = 0; i < arr.length; i++) {
            if (curSum <= 0) {
                curSum = arr[i];
            } else {
                curSum += arr[i];
            }
            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }

    //解法二，动态规划
    public static int findGreatestSumByDP(int[] arr) {
        if (arr == null && arr.length <= 0) {
            throw new RuntimeException("Invalid input!");
        }
        //maxSum[i]表示以数组第i位数字结尾的子数组的最大和
        int[] maxSum = new int[arr.length];
        maxSum[0] = arr[0];
        int result = maxSum[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxSum[i - 1] > 0) {
                maxSum[i] = maxSum[i - 1] + arr[i];
            } else {
                maxSum[i] = arr[i];
            }
            if (maxSum[i] > result) {
                result = maxSum[i];
            }
        }
        return result;
    }
}
