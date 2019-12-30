public class Code_012_MinNumOfRotatedArr {
    //P82，面试题11，找出旋转数组的最小数字
    public static int getMin(int[] arr, int start, int end){
        if(arr == null || start < 0 || end < 0 || end < start){
            throw new RuntimeException("Invalid input!");
        }
        //第二个条件是旋转了0个数字
        if(start == end || arr[start] < arr[end]){
            return start;
        }
        int mid;
        while(end != start + 1){
            mid = ((end - start) >> 1) + start;
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                for(int i = 0; i < arr.length; i++){
                    if(arr[i] < arr[mid]){
                        mid = i;
                    }
                }
                return mid;
            }
            if(arr[mid] >= arr[start]){
                start = mid;
            }else if(arr[mid] <= arr[end]){
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args){
        int[] arr = {3,4,5,6,7,0,1,2};
//        int[] arr = {1,1,1,1,0,1,1,1,1};
        System.out.println("The minimum number is " +
                arr[getMin(arr, 0, arr.length -1)]);
    }
}
