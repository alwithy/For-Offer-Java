public class Code_018_Print1ToMaxOfNDigits {
    //P114,面试题17，打印1到最大的n位数
    //方法1，模拟整数加法
    public static void print1ToMaxNum_1(int n){
        if(n <= 0){
            return;
        }
        char[] num = new char[n];
        for(int i = 0; i < n; i++){
            num[i] = '0';
        }
        while(!increment(num)){
            printNum(num);
        }
    }

    public static void printNum(char[] num){
        System.out.println();
        //找到数字的第一个非零位后开始打印
        boolean findMaxDigitOfNum = false;
        for(int i = 0; i < num.length; i++){
            if(num[i] != 0){
                findMaxDigitOfNum = true;
            }
            if(findMaxDigitOfNum){
                System.out.print(num[i]);
            }
        }
    }

    public static boolean increment(char[] num){
        boolean isOverFlow = false;
        int length = num.length;
        int nTakeOver = 0;
        for(int i = length - 1; i >= 0; i--){
            int nNum = num[i] - '0' + nTakeOver;
            if(i == length - 1){
                nNum++;
            }
            if(nNum >= 10){
                if(i == 0){
                    isOverFlow = true;
                }else{
                    nNum -= 10;
                    num[i] = (char) ('0' + nNum);
                    nTakeOver = 0;
                }
            }else{
                num[i] = (char) ('0' + nNum);
                break;
            }
        }

        return isOverFlow;
    }

    //方法2，递归实现数字全排列
    public static void print1ToMaxNum_2(int n){
        if(n <= 0){
            return;
        }
        char[] num = new char[n];
        for(int i = 0; i < 10; i++){
            num[0] = (char) ('0' + i);
            print1ToMaxOfNDigitsRecursively(num, 0);
        }
    }

    public static void print1ToMaxOfNDigitsRecursively
            (char[] num, int index){
        if(index == num.length - 1){
            printNum(num);
            return;
        }
        for(int i = 0; i < 10; i++){
            num[index + 1] = (char) ('0' + i);
            print1ToMaxOfNDigitsRecursively(num, index + 1);
        }
    }
}
