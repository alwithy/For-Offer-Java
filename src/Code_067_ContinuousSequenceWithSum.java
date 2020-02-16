public class Code_067_ContinuousSequenceWithSum {
    //P282, 面试题57  题目2 和为s的连续正数序列
    public static void findSequencesWithSum(int sum) {
        if (sum < 3) {
            return;
        }

        int small = 1;
        int big = 2;
        int curSum = small + big;
        int mid = (sum - 1)/2;
        //序列至少有两个数字，所以small不能大于mid
        while (small <= mid) {
            if (curSum == sum) {
                printSequence(small, big);
            }

            while (small <= mid && curSum > sum) {
                curSum -= small;
                small++;

                if (curSum == sum) {
                    printSequence(small, big);
                }
            }

            big++;
            curSum += big;
        }
    }

    public static void printSequence(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findSequencesWithSum(3);
        findSequencesWithSum(5);
        findSequencesWithSum(7);
        findSequencesWithSum(9);
        findSequencesWithSum(10);
    }
}
