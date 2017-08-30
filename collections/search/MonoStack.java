package collections.search;

import java.util.Stack;

/**
 * 单调栈.
 * 给定一个数组nums[]，返回一个同样大小的数组rs，其中rs[i]是nums中i之后第一个大于nums[i]的元素的位置. 若不存在，则为-1;
 */
public class MonoStack {
    public static void main(String[] args) {
        int[] nums = new int[] {99};
        int[] rs = monoStack(nums);
        int[][] rss = mStack(nums);
        for(int e : rss[0]) System.out.print(e + " ");
        System.out.println();
        for(int e : rss[1]) System.out.print(e + " ");
    }

    public static int[] monoStack(int[] nums) {
        int[] rs = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                rs[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()) rs[st.pop()] = -1;
        return rs;
    }

    /**
     * 简化版：向右一次扫面即可找到每个元素左右两侧第一个比它小(大)的元素位置；
     * 单调递增栈, 向右扫描，当前元素比栈顶大，则直接入栈；当前元素比栈顶小，则右侧第一个比栈顶元素小的位置得知，栈顶元素出栈，
     * 此时的栈顶元素即弹出元素右侧第一个比它小的位置。
     * 复杂度: O(n)
     */
    public static int[][] mStack(int[] nums) {
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

        // NOTE: 栈中的元素可能是相等的, 而我们求的是左侧第一个比其 "小" 的元素, 不包含 "等于";
        for(int i=1; i<rs[1].length; i++) if(nums[i] == nums[i-1]) rs[1][i] = rs[1][i-1];

        return rs;
    }
}
