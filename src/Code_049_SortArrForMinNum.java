import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Code_049_SortArrForMinNum {
    //P227,面试题45 把数组排成最小数
    public static void printMinNum(int[] arr) {
        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(str, new StringComparator());
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }

    public static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,13,21,45,12};
        printMinNum(arr);
    }
}
