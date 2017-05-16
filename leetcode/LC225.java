package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * author: cshuo
 * date: 2017/3/21
 * version: 1.0
 * description:
 */

public class LC225 {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
