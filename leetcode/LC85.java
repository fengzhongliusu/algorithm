package leetcode;
import java.util.*;

public class LC85 {
    /**
     * 在二维矩阵中可以更直观的表示histogram, 每一列作为一个直方柱，直方柱高等于其中1的个数(从底开始的连续1个数，底为0，则高为0)
     * 所以可以通过遍历每行，分别求出柱体的搞，利用LC84解法求出最大面积.
     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int maxRec = 0;
        int[] hs = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<hs.length; j++) {
                // 0的话更新柱高为0
                if(matrix[i][j] == '0') hs[j] = 0;
                else hs[j]++;
            }
            maxRec = Math.max(maxRec, largestRec(hs));
        }

        return maxRec;
    }

    /**
     * LC84中利用单调栈求解的一维数组表示的histogram的最大面积.
     */
    public int largestRec(int[] heights) {
        if(heights == null || heights.length < 1) return 0;
        Stack<Integer> st = new Stack<>();
        int maxRec = Integer.MIN_VALUE, ele, h;
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
