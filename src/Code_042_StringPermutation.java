public class Code_042_StringPermutation {
    //P197,面试题38 打印一个字符串的所有排列
    public static void printPermutation(String str) {
        if (str.equals("")) {
            return;
        }
        char[] values = str.toCharArray();
        String res = null;
        printPermutationCore(values, 0);
    }

    //i代表下一次要确定的位数
    public static void printPermutationCore(char[] values, int i) {
        if (i == values.length ) {
            System.out.println(String.valueOf(values));
            return;
        }
        for (int j = i ; j < values.length; j++) {
            swap(values, i, j);
            printPermutationCore(values, i + 1);
            swap(values, i, j);
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    //拓展题，打印所有组合
    public static void printCombination(String str) {
        if (str == null) {
            return;
        }
        char[] chs = str.toCharArray();
        printCombinationCore(chs,0);
    }

    //对于chs数组中的每一位，都有选和不选两种状态，用递归解决
    public static void printCombinationCore(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        //本次组合不选择i位char的情况
        char temp = chs[i];
        chs[i] = '\0';
        printCombinationCore(chs, i+1);
        chs[i] = temp;
        printCombinationCore(chs, i+1);
    }

    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str);
        printCombination(str);
    }
}
