public class Code_054_FirstNotRepeatingChar {
    //P243, 面试题50 题目一  第一个只出现一次的字符
    public static char firstNotRepeatingChar(String str) {
        if (str == null) {
            throw new RuntimeException("Invalid input!");
        }
        char[] arr = str.toCharArray();
        int[] hashTable = new int[256];
        for (int i = 0; i < arr.length; i++) {
            hashTable[arr[i]]++;
        }
        char res = '\0';
        for (int i = 0; i < arr.length; i++) {
            if (hashTable[arr[i]] == 1) {
                res = arr[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(firstNotRepeatingChar(str));
    }
}
