package leetcode;

import java.util.Stack;

/**
 * Created by cshuo on 2021/8/7
 */
public class LC84 {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] closetMin = new int[heights.length];
        for (int i = 0; i < closetMin.length; i++) {
            closetMin[i] = closetMin.length;
        }
        Stack<Integer> sk = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!sk.isEmpty() && heights[i] < heights[sk.peek()]) {
                closetMin[sk.pop()] = i;
            }
            sk.push(i);
        }
        sk.clear();
        int max = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!sk.isEmpty() && heights[i] < heights[sk.peek()]) {
                int idx = sk.pop();
                int size = (closetMin[idx] - i - 1) * heights[idx];
                if (size > max) max = size;
            }
            sk.push(i);
        }
        while (!sk.isEmpty()) {
            int idx = sk.pop();
            int size = closetMin[idx] * heights[idx];
            if (size > max) max = size;
        }
        return max;
    }
}
