import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_009_StackAndQueue {
    //P68面试题9，两个栈实现队列,以及两个队列实现一个栈
    public static class TwoStacksQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void appendTail(int value){
            stackPush.push(value);
        }

        public TwoStacksQueue deleteHead(){
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
                stackPop.pop();
                while(!stackPop.isEmpty()){
                    stackPush.push(stackPop.pop());
                }
            }
            return this;
        }
    }

    //两个队列实现栈
    public static class TwoQueueStack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack(){
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int value){
            queue.add(value);
        }

        public int pop(){
            if(queue.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            while(queue.size() > 1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        public int peek(){
            if(queue.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            while(queue.size() > 1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        private void swap(){
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }
}
