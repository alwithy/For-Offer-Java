public class Code_011_QuickSort {
    //P90，实现随机快排
    public static void quickSort(int[] arr, int start, int end){
        if(start == end){
            return;
        }
        int index = partition(arr, start, end);
        if(index > start){
            quickSort(arr, start, index - 1);
        }
        if(index < end){
            quickSort(arr, index + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        if(arr == null || start < 0 || end < 0 || end < start){
            throw new RuntimeException("Invalid input!");
        }
        int index = random(start, end);
        swap(arr, index, end);
        int small = start - 1;
        for(index = start; index < end; index++){
            if (arr[index] < arr[end]){
                swap(arr, index, ++small);
            }
        }
        swap(arr, ++small, end);
        return small;
    }

    public static int random(int start, int end){
        return (int)(Math.random()*(end - start)) + start;
    }

    public static void swap(int[] arr, int a, int b){
        if(a == b){
            return;
        }
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //P82，给年龄排序
    public static void sortAge(int[] ages, int start, int end){
        int oldest = 0;
        int youngest = 100;
        for(int i = start; i < end + 1; i++){
            if(ages[i] > oldest){
                oldest = ages[i];
            }
            if(ages[i] < youngest){
                youngest = ages[i];
            }
        }
        int[] ageTimes = new int[oldest - youngest + 1];
        for(int i = start; i < end + 1; i++){
            ageTimes[ages[i] - youngest]++;
        }
        int index = 0;
        for(int i = 0; i < ageTimes.length; i++){
            for(int j = 0; j < ageTimes[i]; j++){
                ages[index] = i + youngest;
                index++;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1,6,4,5,7,3,2,9,10,8};
        quickSort(arr, 0, 9);
//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i] + " ");
//        }
        int[] ages = {18,23,18,35,35,23,25,45,56,65};
        sortAge(ages, 0, ages.length - 1);
        for(int i = 0; i < ages.length; i++){
            System.out.print(ages[i] + " ");
        }
    }
}
