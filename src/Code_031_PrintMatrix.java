public class Code_031_PrintMatrix {
    //P161,面试题29 顺时针打印矩阵
    public static void printMatrixInCircle(int[][] matrix){
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
            return;
        }
        //用(topRow, topColumn)和（downRow,downColumn）两个点来确定要打印的边
        int topRow = 0;
        int topColumn = 0;
        int downRow = matrix.length - 1;
        int downColumn = matrix[0].length - 1;
        while (topRow <= downRow && topColumn <= downColumn){
            printEdge(matrix, topRow++, topColumn++, downRow--, downColumn--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC){
        //需要打印的“边”只剩一个点
        if (tR == dR && tC == dC){
            print(m[tR][tC]);
        }else if (tR == dR){
            //需要打印的“边”只剩一行
            for (int i = tC; i <= dC; i++){
                print(m[tR][i]);
            }
        }else if (tC == dC) {
            //需要打印的“边”只剩一列
            for (int i = tR; i <= dR; i++) {
                print(m[i][tC]);
            }
        }else {
            for (int i = tC; i < dC; i++) {
                print(m[tR][i]);
            }
            for (int i = tR; i < dR; i++) {
                print(m[i][dC]);
            }
            for (int i = dC; i > tC; i--){
                print(m[dR][i]);
            }
            for (int i = dR; i > tR; i--){
                print(m[i][tC]);
            }
        }
    }

    public static void print(int value){
        System.out.println(value);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        printMatrixInCircle(matrix);

        int[][] matrix2 = {
                { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 9},
        };
        printMatrixInCircle(matrix2);
    }
}
