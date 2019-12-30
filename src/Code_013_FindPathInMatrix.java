public class Code_013_FindPathInMatrix {
    //P89,面试题12，矩阵中的路径
    public static boolean hasPath(char[][] matrix, String str){
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1
        || str == null){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[] charStr = str.toCharArray();
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(hasPathCore(matrix, charStr,
                        row, col, pathLength,
                        visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[][] matrix, char[] charStr,
                                      int row, int col, int pathLength,
                                      boolean[][] visited){
        if(pathLength == charStr.length){
            return true;
        }
        boolean hasPath = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(row >= 0 && row < rows && col >= 0 && col < cols
        && matrix[row][col] == charStr[pathLength]
        && !visited[row][col]){
            pathLength++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, charStr,
                    row + 1, col, pathLength, visited)
                    || hasPathCore(matrix, charStr,
                    row - 1, col, pathLength, visited)
                    || hasPathCore(matrix, charStr,
                    row, col + 1, pathLength, visited)
                    || hasPathCore(matrix, charStr,
                    row, col - 1, pathLength, visited);
            if(!hasPath){
                pathLength--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args){
        char[][] matrix = {{'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        String str = "bfce";
        boolean hasPath = hasPath(matrix, str);
        System.out.println("The matrix has path? \n " + hasPath);
    }
}
