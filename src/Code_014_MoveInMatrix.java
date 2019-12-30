public class Code_014_MoveInMatrix {
    //P92，面试题13，机器人的运动范围
    public static int movingCount(int threshold, int rows, int cols){
        if(threshold < 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols,
                0, 0, visited);
        return count;
    }

    public static int movingCountCore(int threshold, int rows, int cols,
                                      int row, int col,
                                      boolean[][] visited){
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited)){
            visited[row][col] = true;
            count = 1 + movingCountCore(threshold, rows, cols,
                    row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols,
                            row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols,
                            row, col + 1, visited) +
                    movingCountCore(threshold, rows, cols,
                            row, col - 1, visited);
        }
        return count;
    }

    public static boolean check(int threshold, int rows, int cols,
                            int row, int col,
                            boolean[][] visited){
        if(row < rows && col < cols && !visited[row][col]
        && getDigitSum(row) + getDigitSum(col) <= threshold){
            return true;
        }
        return false;
    }

    public static int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args){

    }
}
