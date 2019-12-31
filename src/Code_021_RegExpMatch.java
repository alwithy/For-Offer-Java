import java.util.Arrays;

public class Code_021_RegExpMatch {
    //P124,面试题19 正则表达式匹配
    public static boolean matchRegExp(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    private static boolean matchCore(char[] str, int strIndex,
                                 char[] pattern, int patternIndex) {
        if(strIndex == str.length
                && patternIndex == pattern.length){
            return true;
        }
        if( !(strIndex == str.length)
                && patternIndex == pattern.length){
            return false;
        }
        char patternChar = pattern[patternIndex];
        char patternCharNext = pattern[patternIndex + 1];

        if(strIndex == str.length){
            if( !(patternCharNext == '*')){
                return false;
            }else{
                return matchCore(str, strIndex,
                        pattern, patternIndex + 2);
            }
        }
        char strChar = str[strIndex];

        if( patternCharNext == '*'){
            if(strChar == patternChar || patternChar == '.'){
                //str留在原地，pattern跳两格，代表'*'前的内容显示0次
                //进行'*'之后的匹配
                return matchCore(str, strIndex,
                        pattern, patternIndex + 2)
                        //str跳一格，pattern留在原地，代表'*'前的内容显示1次
                        //持续匹配'*'及之前一格的内容
                        || matchCore(str, strIndex + 1,
                        pattern, patternIndex)
                        //'*'前内容显示一次，进行'*'之后的匹配
                        || matchCore(str, strIndex + 1,
                        pattern, patternIndex + 2);
            }else{
                //进行'*'之后的匹配
                return matchCore(str, strIndex,
                        pattern, patternIndex + 2);
            }
        }

        if(strChar == patternChar || patternChar == '.'){
            return matchCore(str, strIndex + 1,
                    pattern, patternIndex + 1);
        }

        return false;
    }
}
