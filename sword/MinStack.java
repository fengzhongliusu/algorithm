package sword;
import java.util.*;

/**
 * Created by cshuo on 2017/8/14
 */
public class MinStack {
    Stack<Integer> data = new Stack<>(), min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(min.isEmpty()) min.push(node);
        else if(node <= min.peek()) min.push(node);
    }

    public void pop() {
        int val;
        if(!data.isEmpty()){
            val = data.pop();
            if(val <= min.peek()) min.pop();
        }
    }

    public int top() {
        return data.isEmpty() ? -1 : data.pop();
    }

    public int min() {
        return min.isEmpty() ? -1 : min.peek();
    }
}
