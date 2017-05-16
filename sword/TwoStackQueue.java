package sword;

import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class TwoStackQueue {
    public static void main(String[] args) {
    }
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();

    public void push(int val){
        st1.push(val);
    }

    public int pop(){
        if(!st2.isEmpty()) return st2.pop();
        while(!st1.isEmpty()) st2.push(st1.pop());
        if(!st2.isEmpty()) return st2.pop();
        return -1;
    }
}
