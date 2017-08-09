package leetcode;

/**
 * Created by cshuo on 2017/8/4
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24
 Note:
 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class LC628 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,-2,-3};
        System.out.println(maximumProduct(arr));
    }

    /**
     * 找到最大的三个数和最小的两个数, 最后取max(max1*max2*max3, min1*min2*min3);
     */
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int e: nums) {
            if(e > max3) {
                max1 = max2; max2 = max3; max3 = e;
            } else if(e > max2) {
                max1 = max2; max2 = e;
            } else if(e > max1) {
                max1 = e;
            }
            if (e < min2) {
                min1 = min2; min2 = e;
            } else if (e < min1) {
                min1 = e;
            }
        }
        return Math.max(min1*min2*max3, max1*max2*max3);
    }
}
