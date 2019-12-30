public class Code_010_Fibonacci {
    //P74，面试题10，求斐波那切数列的第n项
    //递归略，非递归如下
    public static long fibonacci(int n){
        if(n < 0){
            return -1;
        }
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        long cur = 1;
        long pre = 1;
        long res = 0;
        for(int i = 0; i < n - 2; i++){
            res = cur + pre;
            pre = cur;
            cur = res;
        }
        return res;
    }

    public static void main(String[] args){
        int n = 5;
        long res = fibonacci(n);
        System.out.println(res);
    }
}
