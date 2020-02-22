import java.util.Arrays;

public class Code_073_ContinousCards {
    //P298,面试题61 扑克牌中的顺子

    //大小王定义为0
    public static boolean isContinous(int[] arr) {
        if (arr == null || arr.length < 1) {
            return false;
        }

        Arrays.sort(arr);
        int numOfZero = 0;
        int numOfGap = 0;
        //统计0的个数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                numOfZero++;
            }
        }

        //统计数组中间隔的数目
        int small = numOfZero;
        int big = small + 1;
        while (big < arr.length) {
            if (arr[small] == arr[big]) {
                return false;
            }

            numOfGap += arr[big] - arr[small] - 1;
            small = big;
            big++;
        }

        return numOfGap <= numOfZero;
    }
}
