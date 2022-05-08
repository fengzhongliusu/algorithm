package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Created by cshuo on 2021/8/16
 *
 * ["MinStack","push","push","push","top","pop","getMin","pop","getMin", "pop", "push","top","getMin","push","top","getMin","pop","getMin"]
 * [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
 * [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
 */
public class LC155 {
    /** initialize your data structure here. */
    Stack<Long> sk = new Stack<>();
    long min = Long.MAX_VALUE;

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.merge(1, 1, (integer, integer2) -> integer + integer2);
        LC155 test =new LC155();
        test.push(2147483646);
        test.push(2147483646);
        test.push(2147483647);
        System.out.println(test.top());
        test.pop();
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
        test.pop();
        test.push(2147483647);
        System.out.println(test.top());
        System.out.println(test.getMin());
        test.push(-2147483648);
        System.out.println(test.top());
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
    }


    public void push(int val) {
        long val1 = val;
        if (sk.isEmpty()) {
            sk.push(0L);
            min = val;
            return;
        }
        sk.push(val1 - min);
        if (val1 < min) min = val;
    }

    public void pop() {
        long top = sk.pop();
        if (top < 0) min = min - top;
    }

    public int top() {
        long top = sk.peek();
        if (top < 0) return (int) min;
        else return (int) (top + min);
    }

    public int getMin() {
        return (int) min;
    }
}
