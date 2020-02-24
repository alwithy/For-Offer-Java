public class Code_078_ConstructArray {
    //P312,面试题66 构建乘积数组

    public static long[] multiply1(long[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        //arr1[i] = arr[0] * arr[1] * ... * arr[i - 1]
        //计算方法为arr1[i] = arr1[i - 1] * arr[i - 1]
        long[] arr1 = new long[arr.length];

        //arr2[i] = arr[i + 1] * arr[i + 2] * ... * arr[n - 1]
        //计算方法为arr2[i] = arr2[i + 1] * arr[i + 1]
        long[] arr2 = new long[arr.length];

        //res存放结果
        //计算方法为res[i] = arr1[i] * arr2[i]
        long[] res = new long[arr.length];

        //计算arr1
        arr1[0] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr1[i] = arr1[i - 1] * arr[i - 1];
        }

        //计算arr2和res
        arr2[arr2.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            arr2[i] = arr2[i + 1] * arr[i + 1];
            res[i] = arr1[i] * arr2[i];
        }

        return res;
    }

    //将multiply1代码简化，只申请一个新数组
    public static long[] multiply2(long[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        //arr1[i] = arr[0] * arr[1] * ... * arr[i - 1]
        //计算方法为arr1[i] = arr1[i - 1] * arr[i - 1]
        long[] arr1 = new long[arr.length];

        //arr2[i] = arr[i + 1] * arr[i + 2] * ... * arr[n - 1]
        //计算方法为arr2[i] = arr2[i + 1] * arr[i + 1]
        //long[] arr2 = new long[arr.length];

        //计算arr1
        arr1[0] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr1[i] = arr1[i - 1] * arr[i - 1];
        }

        //计算arr2
        //使用temp存放arr2[i + 1],最终的结果放在arr1中
        long temp = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            temp *= arr[i + 1];
            arr1[i] *= temp;
        }

        return arr1;
    }
}
