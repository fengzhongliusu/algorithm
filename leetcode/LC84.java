package leetcode;
import java.util.*;


/**
 * 利用单调栈来分别计算对于任意一个元素heights[i],其左侧和右侧第一个比它小的元素的位置, 然后分别计算出以heights[i]为高的矩形的面积.
 */
public class LC84 {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length < 1) return 0;
        int[] rLess = monoStack(heights, 0);
        int[] lLess = monoStack(heights, 1);
        int maxRec = Integer.MIN_VALUE, rec;
        for(int i=0; i<heights.length; i++) {
            rec = heights[i] * (rLess[i] - lLess[i] - 1);
            if(rec > maxRec) maxRec = rec;
        }
        return maxRec;
    }

    /**
     * sign 为 0：求解每个元素右侧第一个比他小的元素的位置;
     * sign 为 1：求解每个元素左侧第一个比他小的元素的位置;
     */
    public int[] monoStack(int[] nums, int sign) {
        int start = sign==0 ? 0 : nums.length - 1;
        int[] rs = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        while(true) {
            if(sign == 0 && start >= nums.length || sign == 1 && start < 0) break;
            while(!st.isEmpty() && nums[st.peek()] > nums[start]) {
                rs[st.pop()] = start;
            }
            st.push(start);
            start += sign == 0 ? 1:-1;
        }
        while(!st.isEmpty()) rs[st.pop()] = sign==0 ? nums.length : -1;
        return rs;
    }

    /**
     * 简化版：单调递增栈, 向右扫描，当前元素比栈顶大，则直接入栈；当前元素比栈顶小，则右侧第一个比栈顶元素小的位置得知，栈顶元素出栈，
     * 此时的栈顶元素即弹出元素右侧第一个比它小的位置。
     */
    public static int largestRec(int[] heights) {
        if(heights == null || heights.length < 1) return 0;
        Stack<Integer> st = new Stack<>();
        int maxRec = Integer.MIN_VALUE, ele, h;
        for(int i=0; i<= heights.length; i++) {
            ele = i==heights.length ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] > ele) {
                h = heights[st.pop()];
                int l = (st.isEmpty() ? -1:st.peek());
                maxRec = Math.max(h*(i-l-1), maxRec);
                System.out.println(h+": " + h*(i-l-1));
            }
            st.push(i);
        }
        return maxRec;
    }

    /**
     * 简化版：向右一次扫面即可找到每个元素左右两侧第一个比它小(大)的元素位置；
     * 单调递增栈, 向右扫描，当前元素比栈顶大，则直接入栈；当前元素比栈顶小，则右侧第一个比栈顶元素小的位置得知，栈顶元素出栈，
     * 此时的栈顶元素即弹出元素右侧第一个比它小的位置。
     * 复杂度: O(n)
     */
    public static int[][] monoStack(int[] nums) {
        int[][] rs = new int[2][nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            while(!st.isEmpty() && nums[i] < nums[st.peek()]) {
                rs[0][st.peek()] = i;
                rs[1][st.pop()] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(i);
        }
        // 此时栈可能非空，继续处理；根据情况可以使用trick进行简洁处理，如在nums最后增加一个元素MINVALUE, 即可保证跳出循环时，所有元素都处理了。
        while(!st.isEmpty()) {
            rs[0][st.peek()] = -1;
            rs[1][st.pop()] = st.isEmpty() ? -1 : st.peek();
        }
        return rs;
    }


    public static void main(String[] args) {
        int[] hs = new int[] {2,1,5,5,6,2,3};
        System.out.println(largestRec(hs));
//        int[][] rs = monoStack(hs);
//        for(int e: rs[0]) System.out.print(e+ " ");
//        System.out.println();
//        for(int e: rs[1]) System.out.print(e+ " ");
    }
}
