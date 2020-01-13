import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_045_StreamMedian {
    //P214,面试题41 数据流的中位数
    public static class MedianHolder {
        //大根堆存放较小的一半数字，小根堆存放较大的
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());

        private void modifyTwoHeapSize() {
            if (this.maxHeap.size() == this.minHeap.size() + 2) {
                this.minHeap.add(this.maxHeap.poll());
            }
            if (this.minHeap.size() == this.maxHeap.size() + 2) {
                this.maxHeap.add(this.minHeap.poll());
            }
        }

        public void addNumber(int num) {
            if (maxHeap.isEmpty()) {
                this.maxHeap.add(num);
                return;
            }
            if (num <= this.maxHeap.peek()) {
                this.maxHeap.add(num);
            } else {
                if (this.minHeap.isEmpty()) {
                    this.minHeap.add(num);
                    return;
                }
                if (num >= this.minHeap.peek()) {
                    this.minHeap.add(num);
                } else {
                    this.maxHeap.add(num);
                }
            }
            modifyTwoHeapSize();
        }

        public Integer getMedian() {
            if (this.minHeap.isEmpty() && this.maxHeap.isEmpty()) {
                return null;
            }
            if (this.minHeap.size() == this.maxHeap.size() + 1) {
                return this.minHeap.peek();
            }
            if (this.maxHeap.size() == this.minHeap.size() + 1) {
                return this.maxHeap.peek();
            } else {
                return (this.minHeap.peek() + this.maxHeap.peek())/2;
            }
        }
    }

    public static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }
}
