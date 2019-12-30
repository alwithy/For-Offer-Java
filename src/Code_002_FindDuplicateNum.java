import java.util.HashSet;
//P39，面试题3
public class Code_002_FindDuplicateNum {
    //题目一，所有数字都在0~n-1范围内,找出任意一个重复数字
    //HashSet实现
    public static int findDuplicate1(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0 || arr[i] > arr.length -1){
                return -1;
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(hashSet.contains(arr[i])){
                //System.out.print(arr[i]+" ");
                return arr[i];
            }else{
                hashSet.add(arr[i]);
            }
        }
        return -1;
    }

    //扫描实现
    public static int findDuplicate2(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0 || arr[i] > arr.length -1){
                return -1;
            }
        }
        for(int i = 0; i < arr.length; i++){
            while(arr[i] != i){
                if(arr[i] == arr[arr[i]]){
                    //System.out.print(arr[i]+" ");
                    return arr[i];
                }
                swap(arr, i, arr[i]);
            }
        }
        return -1;
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //题目二，不修改数组找出重复数字
    //二分查找类似的思路
    public static int findDuplicateWithoutSwap(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int start = 1;
        int end = arr.length - 1;
        while(end >= start){
            int middle = ((end-start)>>2) + start;
            int count = countRange(arr, start, middle);
            if(end == start){
                if(count > 1){
                    return start;
                }else{
                    break;
                }
            }
            if(count > middle - start + 1){
                end = middle;
            }else{
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] arr, int start, int end){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >=start && arr[i] <= end){
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args){
        int[] arr = {2,0,1,1,3};
        //findDuplicate1(arr, dup);
        System.out.println(findDuplicate1(arr));
    }
}
