import java.util.Arrays;
import java.util.function.IntFunction;

public class Code_076_Accumulate {
    //P307,面试题64  求1 + 2 + ··· + n

    //利用递归
    private static int sumSolution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumSolution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumSolution(3));
    }
}
