import java.util.ArrayDeque;
import java.util.Deque;

public class Code_071_QueueWithMax {
    //P292,面试题59  题目2 队列的最大值
    class QueueWithMax<T extends Comparable> {
        private class InternalData {
            T number;
            int index;

            InternalData(T number, int index) {
                this.number = number;
                this.index = index;
            }
        }

        private Deque<InternalData> data;
        private Deque<InternalData> maximums;
        private int currentIndex;

        public QueueWithMax() {
            currentIndex = 0;
            data = new ArrayDeque<>();
            maximums = new ArrayDeque<>();
        }

        public void push_back(T number) {
            while (!maximums.isEmpty()
                    && number.compareTo(maximums.getLast().number) >= 0) {
                maximums.removeLast();
            }

            InternalData internalData =
                    new InternalData(number, currentIndex);
            data.addLast(internalData);
            maximums.addLast(internalData);
            currentIndex++;
        }

        public void pop_front() {
            if (maximums.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            if (maximums.getFirst().number.
                    equals(data.getFirst().number)) {
                maximums.removeFirst();
            }

            data.removeFirst();
        }

        public T getMax() {
            if (maximums.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            return maximums.getFirst().number;
        }
    }
}
