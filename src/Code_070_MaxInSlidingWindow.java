import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_070_MaxInSlidingWindow {
    //P288,面试题59  题目1 滑动窗口的最大值
    public static Queue<Integer> maxInWindows(int[] arr, int size) {
        if (arr == null || size <= 0 || arr.length < size) {
            return null;
        }
        //res存放返回的队列
        Queue<Integer> res = new LinkedList<>();
        //index是一个双向队列，存放了滑动窗口可能的最大值的下标
        //第一个元素为目前最大值，之后的元素为第一个元素滑出窗口后可能的最大值
        Deque<Integer> index = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            while(!index.isEmpty() && arr[i] >= arr[index.getLast()]) {
                index.removeLast();
            }
            index.addLast(i);
        }

        for (int i = size; i < arr.length; i++) {
            res.add(arr[index.getFirst()]);

            while(!index.isEmpty() && arr[i] >= arr[index.getLast()]) {
                index.removeLast();
            }
            if (!index.isEmpty() && index.getFirst() + size <= i) {
                index.removeFirst();
            }
            index.addLast(i);
        }
        res.add(arr[index.getFirst()]);

        return res;
    }

    public static void printQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 3 , 4, 2, 6, 2, 5, 1};
        Queue<Integer> res = maxInWindows(arr, 3);
        printQueue(res);
    }
}
