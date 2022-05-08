package leetcode;

import java.util.Stack;

/**
 * Created by cshuo on 2021/8/7
 */
public class LC85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) return 0;
        int maxRec = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j]++;
            }
            int size = largestRectangleArea(height);
            if (size > maxRec) maxRec = size;
        }
        return maxRec;
    }

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length < 1) return 0;
        Stack<Integer> st = new Stack<>();
        int maxRec = 0, ele, h;
        for(int i=0; i<= heights.length; i++) {
            ele = i==heights.length ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] > ele) {
                h = heights[st.pop()];
                int l = (st.isEmpty() ? -1:st.peek());
                maxRec = Math.max(h*(i-l-1), maxRec);
            }
            st.push(i);
        }
        return maxRec;
    }
}
