import java.util.Stack;

public class Code_032_MinInStack {
    //P166, 面试题30 包含min函数的栈
    public static class StackWithMin {
        Stack<Integer> data;
        Stack<Integer> min;

        public StackWithMin() {
            this.data = new Stack<Integer>();
            this.min = new Stack<Integer>();
        }

        public void push(int value) {
            data.push(value);

            if (min.isEmpty() || min.peek() > value) {
                min.push(value);
            } else {
                min.push(min.peek());
            }
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            } else {
                return data.peek();
            }
        }

        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            } else {
                min.pop();
                return data.pop();
            }
        }

        public int getMin() {
            if (data.isEmpty()) {
                throw new RuntimeException("The stack is empty!");
            } else {
                return min.peek();
            }
        }
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(4);
        System.out.println("The minimum num of stack is :" + stack.getMin());
        stack.push(2);
        stack.push(1);
        stack.push(0);
        System.out.println("The minimum num of stack is :" + stack.getMin());
        System.out.println("The top of stack is :" + stack.pop());
        System.out.println("The minimum num of stack is :" + stack.getMin());
    }
}
