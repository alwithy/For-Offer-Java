import java.util.Objects;

public class Code_017_Power {
    //P110,面试题16，数值的整数次方
    static boolean isValidInput = false;
    public static double power(Double base, int exponent){
        isValidInput = false;
        if(base < 0.0){
            return 0;
        }
        if(base.equals(0.0)){
            if(exponent < 0){
                isValidInput = false;
            }else{
                isValidInput = true;
            }
            return 0;
        }
        isValidInput = true;
        if(exponent == 0){
            return 1;
        }
        if(exponent < 0){
            exponent = Math.abs(exponent);
        }
        double res = 1.0;
        for(int i = 0; i < exponent; i++){
            res *= base;
        }
        return res;
    }

    //无符号数更快求次方
    public static double powerWithUnsignedExponent(Double base, int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }

        double res = powerWithUnsignedExponent(base, exponent >> 1);
        res *= res;
        if((exponent & 1) == 1){
            res *= base;
        }
        return res;
    }

    public static void main(String[] args){
        int a = 1 & 2;
        Double base = (double) 9.0f;
        System.out.println(a);
    }
}
