package leetcode;

/**
 * Created by cshuo on 2021/10/7
 */
public class LC238 {
    public static void main(String[] args) {
        int[] ns = new int[] {1,2,3,4};
        productExceptSelf(ns);
    }
    public static int[] productExceptSelf(int[] nums) {
        if(nums == null) return null;
        int[] rs = new int[nums.length];
        int tmp = 1;
        for(int i=0; i<nums.length; tmp *= nums[i++])
            rs[i] = tmp;
        for(int i=nums.length-1; i>=0; tmp *= nums[i--])
            rs[i] *= tmp;
        return rs;
    }
}
