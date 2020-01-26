public class Code_051_MaxValueOfGifts {
    //P233,面试题47 礼物的最大价值

    //使用动态规划
    public static int getMaxValue1(int[][] gift) {
        if (gift == null) {
            throw new RuntimeException("Invalid input!");
        }
        int row = gift.length;
        int col = gift[0].length;
        int[][] maxValue = new int[row][col];
        int up = 0;
        int left = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                up = 0;
                left = 0;
                if (i > 0) {
                    up = maxValue[i - 1][j];
                }
                if (j > 0) {
                    left = maxValue[i][j - 1];
                }
                maxValue[i][j] = Math.max(up, left) + gift[i][j];
            }
        }
        return maxValue[row - 1][col - 1];
    }

    //优化代码
    public static int getMaxValue2(int[][] gift) {
        if (gift == null) {
            throw new RuntimeException("Invalid input!");
        }
        int row = gift.length;
        int col = gift[0].length;
        int[] maxValue = new int[col];
        int left = 0;
        int up = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                up = 0;
                left = 0;
                if (i > 0) {
                    up = maxValue[j];
                }
                if (j > 0) {
                    left = maxValue[j - 1];
                }
                maxValue[j] = Math.max(up, left) + gift[i][j];
            }
        }
        return maxValue[col - 1];
    }

    public static void main(String[] args) {
        int[][] gift = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}};
        System.out.println(getMaxValue1(gift));
        System.out.println(getMaxValue2(gift));
    }
}
