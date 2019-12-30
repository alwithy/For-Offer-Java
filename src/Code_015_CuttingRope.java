public class Code_015_CuttingRope {
    //P96，面试题14 剪绳子。（m不是给定值）
    //动态规划
    public static int maxProductAfterCut1(int length){
        if(length < 2){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        if(length == 3){
            return 2;
        }
        int[] product = new int[length + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        int max = 0;
        for(int i = 4; i <= length; i++){
            max = 0;
            for(int j = 1; j <= i/2; j++){
                int temp = product[j] * product[i - j];
                if(temp > max){
                    max = temp;
                }
            }
            product[i] = max;
        }
        return product[length];
    }

    //贪心
    public static int maxProductAfterCut2(int length){
        if(length < 2){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        if(length == 3){
            return 2;
        }
        int timesOf3 = length / 3;
        if(length - timesOf3 * 3 == 1){
            timesOf3--;
        }

        int timesOf2 = (length - timesOf3 * 3)/2;

        return pow(timesOf3, 3) * pow(timesOf2, 2);
    }

    public  static int pow(int times, int basis){
        int product = 1;
        for(int i = 0; i < times; i++){
            product *= basis;
        }
        return product;
    }

    public static void main(String[] args){
        int solution1 = maxProductAfterCut1(10);
        int solution2 = maxProductAfterCut2(10);
        System.out.println("动态规划结果是：" + solution1);
        System.out.println("贪心算法结果是：" + solution2);
    }
}
