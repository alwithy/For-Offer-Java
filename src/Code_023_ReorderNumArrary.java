public class Code_023_ReorderNumArrary {
    //P129,面试题21 调整数组顺序
    //双指针法
    public static void reorderOddEven(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end){
            while(begin < end && (arr[begin] & 1) != 0){
                begin++;
            }

            while(begin < end && (arr[end] & 1 ) != 1){
                end--;
            }
            swap(arr, begin, end);
        }
    }

    //可拓展式函数
    public static void reorder(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end){
            while(begin < end && !func(arr, begin)){
                begin++;
            }

            while(begin < end && func(arr,end)){
                end--;
            }
            swap(arr, begin, end);
        }
    }

    public static boolean func(int[] arr, int index){
        return (arr[index] & 1) == 0;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6};
        reorderOddEven(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

    }
}
