public class Code_072_DiceProbability {
    //P294, 面试题60 n个骰子的点数

    public static final int maxValue = 6;

    //递归
    public static void printProbability1(int num) {
        if (num < 1) {
            return;
        }

        int maxSum = maxValue * num;
        //最终和为n的情况总数对应probabilities数组的第n - num号元素
        int[] probabilities = new int[maxSum - num + 1];
        probabilities(num, probabilities);
        System.out.println("方法一：递归");
        for (int i = 0; i < probabilities.length; i++){
            System.out.println
                    ("和为" + (i + num) + "共" + probabilities[i] + "次");
        }
    }

    public static void probabilities(int num, int[] probabilities) {
        for (int i = 1; i <= maxValue; i++) {
            probabilities(num, num, i, probabilities);
        }
    }

    public static void probabilities(int original, int current,
                                     int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probabilities(original, current - 1,
                        sum + i, probabilities);
            }
        }
    }

    //方法二，循环
    public static void printProbability2(int num) {
        if (num < 1) {
            return;
        }

        int[][] probabilities = new int[2][maxValue * num + 1];
        int flag = 0;

        for (int i = 1; i <= maxValue; i++) {
            probabilities[flag][i] = 1;
        }

        for (int k = 2; k <= num; k++) {
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }

            for (int i = k; i <= maxValue * num; i++) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    probabilities[1 - flag][i]
                            += probabilities[flag][i - j];
                }
            }

            flag = 1 - flag;
        }

        System.out.println("方法二：循环");
        for (int i = num; i <= maxValue * num; i++) {
            System.out.println
                    ("和为" + i + "共" + probabilities[flag][i] + "次");
        }


    }

    public static void main(String[] args) {
        printProbability1(2);
        printProbability2(2);
    }
}
