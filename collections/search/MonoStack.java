package collections.search;

import java.util.Stack;

/**
 * 单调栈.
 * 给定一个数组nums[]，返回一个同样大小的数组rs，其中rs[i]是nums中i之后第一个大于nums[i]的元素的位置. 若不存在，则为-1;
 */
public class MonoStack {
    public static void main(String[] args) {
        int[] nums = new int[] {3,4,5,9,9};
        int[] rs = monoStack(nums);
        for(int e : rs) System.out.println(e);
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
}
