import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code_022_NumExpression {
    //P127,面试题20 表示数值的字符串
    //正则表达式解决
    public static boolean isNumeric(String str){
        if(str == null){
            return false;
        }
        boolean match = false;
        if(str.contains("E") || str.contains("e")){
            match = str.matches("[+|-]?[0-9]*[.]?[0-9]*[eE]?[-|+]?[0-9]");
        }else{
            match = str.matches("[+|-]?[0-9]*[.]?[0-9]*");
        }
        return match;
    }

    public static void main(String[] args){
        String str = "1.23";
        System.out.println(isNumeric(str));
    }
}
