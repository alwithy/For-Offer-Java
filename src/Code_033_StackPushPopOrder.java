import java.util.Stack;

public class Code_033_StackPushPopOrder {
    //P168,面试题31 栈的压入，弹出序列
    public static boolean isPopOrder (int[] push, int[] pop) {
        boolean res = false;
        if (push != null && pop != null
                && push.length == pop.length
                && push.length > 0) {
            int p1 = 0;
            int p2 = 0;
            int length = push.length;
            Stack<Integer> stack = new Stack<>();
            while (p2 < length) {
                while (stack.isEmpty() || stack.peek() != pop[p2]) {
                    if (p1 == length ) {
                        break;
                    }
                    stack.push(push[p1++]);
                }

                if (stack.peek() == pop[p2]){
                    p2++;
                    stack.pop();
                } else {
                    break;
                }

                if (p1 == length && p2 == length) {
                    res = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] push = { 1, 2, 3, 4, 5};
        int[] pop1 = { 4, 5, 3, 2, 1};
        int[] pop2 = { 4, 3, 5, 1, 2};
        System.out.println(isPopOrder(push, pop1));
        System.out.println(isPopOrder(push, pop2));

    }
}
