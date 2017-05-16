package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * author: cshuo
 * date: 2017/4/28
 * version: 1.0
 * description: 找到一个数组中每个元素右边第一个大于它的元素.
 */
public class RightFirstLarge {
    public static void main(String[] args) {
        int[] nums = new int[]{9,9,6,5,7,3,2,1,5,9,10};
        int[] rs =  getRightLarge(nums);
        System.out.println(Arrays.toString(rs));
    }

    public static int[] getRightLarge(int [] nums){
        int[] rs = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length;){
            if(st.isEmpty() || nums[st.peek()] >= nums[i]){
                st.push(i++);
            } else{
                rs[st.pop()] = nums[i];
            }
        }
        while(!st.isEmpty()){
            rs[st.pop()] = Integer.MAX_VALUE;
        }
        return rs;
    }
}
