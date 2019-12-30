public class Code_016_CountNumOf1 {
    //P100，面试题15，二进制中1的个数
    public static int numOf1_1(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int numOf1_2(int n){
        int count = 0;
        while(n != 0){
            count ++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args){
        int a = 1 & 2;
        System.out.println(a);
    }
}
