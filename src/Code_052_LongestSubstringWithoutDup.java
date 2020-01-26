public class Code_052_LongestSubstringWithoutDup {
    //P236,面试题48 最长不含重复字符的子序列
    public static int longestSubWithoutDup(String str) {
        if (str == null) {
            throw new RuntimeException("Invalid input!");
        }
        char[] charArr = str.toCharArray();
        //sub记录当前的最长子字符串
        StringBuilder maxSub = new StringBuilder(String.valueOf(charArr[0]));
        //max[i]记录以第i位字符结尾的子字符串的最大长度
        int[] max = new int[str.length()];
        max[0] = 1;
        char cur;
        for (int i = 1; i < str.length(); i++) {
            cur = charArr[i];
            if (!maxSub.toString().contains(String.valueOf(cur))) {
                max[i] = max[i - 1] + 1;
                maxSub.append(cur);
            } else {
                max[i] = 1;
                maxSub = new StringBuilder(String.valueOf(cur));
            }
        }
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (res < max[i]) {
                res = max[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(longestSubWithoutDup(str));
    }
}
