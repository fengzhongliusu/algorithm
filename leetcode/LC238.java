package leetcode;

/**
 * Created by cshuo on 2017/8/4
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to
 * the product of all the elements of nums except nums[i].
 Solve it without division and in O(n).
 For example, given [1,2,3,4], return [24,12,8,6].
 */
public class LC238 {
    /**
     * 以数组nums为行绘制一个正方形，如下：
       a 2 3 4
       1 b 3 4
       1 2 c 4
       1 2 3 d
     对角线上即所需求解的数组, 可以将计算过程分成两个部分，对角线上三角和下三角，每个三角可以使用前缀积的形式O(n)计算出。
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null) return null;
        int[] rs = new int[nums.length];
        int tmp = 1;
        for(int i=0; i<nums.length; tmp *= nums[i++])
            rs[i] = tmp;
        tmp = 1;
        for(int i=nums.length-1; i>=0; tmp *= nums[i--])
            rs[i] *= tmp;
        return rs;
    }
}
