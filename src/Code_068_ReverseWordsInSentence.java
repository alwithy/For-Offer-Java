public class Code_068_ReverseWordsInSentence {
    //P284, 面试题58 翻转字符串
    public static String[] reverse(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] res = str.split(" ");
        int ahead = res.length - 1;
        int behind = 0;
        while (behind < ahead) {
            swap(res, ahead, behind);
            ahead--;
            behind++;
        }
        return res;
    }

    public static void swap(String[] res, int i, int j) {
        String temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }

    public static void main(String[] args) {
        String str = "I miss you.";
        String[] res = reverse(str);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
