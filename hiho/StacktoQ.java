package hiho;

import java.util.Queue;
import java.util.Stack;

/**
 * construct a Queue using two stack.
 */
public class StacktoQ {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty())
            return stack2.pop();
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        if(!stack2.isEmpty())
            return stack2.pop();
        return 0;
    }

    public static void main(String[] args) {
        StacktoQ sq = new StacktoQ();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        sq.push(4);
        System.out.println(sq.pop());
        sq.push(5);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
    }
}
