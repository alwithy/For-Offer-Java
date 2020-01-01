public class Code_022_NumExpression {
    //P127,面试题20 表示数值的字符串
    //正则表达式解决
    public static boolean isNumeric1(String str){
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

    //字符串编码解决
    public static boolean isNumeric2(String str){
        if(str.contains("E")){
           String[] strArray = str.split("E");
           if(strArray.length > 2){
               return false;
           }else{
               return scanInteger(strArray[0])
                       && scanInteger(strArray[1]);
           }
        }
        if(str.contains("e")){
            String[] strArray = str.split("e");
            if(strArray.length > 2){
                return false;
            }else{
                return scanInteger(strArray[0])
                        && scanInteger(strArray[1]);
            }
        }
        return scanInteger(str);
    }

    private static boolean scanInteger(String str) {
        char[] strChar = str.toCharArray();
        if(strChar[0] == '-' || strChar[0] == '+'){
            str = str.substring(1);
        }
        return scanUnsignedInteger(str);
    }

    private static boolean scanUnsignedInteger(String str) {
        String[] strInteger = str.split(".");
        if(strInteger.length > 2){
            return false;
        }
        for(String strSub : strInteger){
            char[] strSubCharArray = strSub.toCharArray();
            for(char num : strSubCharArray){
                if(num < '0' || num > '9'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        String str = "1E23";
        String[] str1 = str.split("a");
        System.out.println(str1[0]);
        boolean isNum = isNumeric2(str);
        System.out.println(isNum);
    }
}
