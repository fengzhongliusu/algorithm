package leetcode;

import java.util.ArrayList;

/**
 * maximum subarray
 */
public class MaxSubArr {
    public static int maxSubArr(int[] nums){
        if(nums == null || nums.length < 1) return 0;
        int max = Integer.MIN_VALUE, sum = 0;
        ArrayList<Integer> rs = new ArrayList<>(); //end of the max sub array.
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
//            max = Math.max(max, sum);
            if(sum == max) rs.add(i);
            else if(sum > max){
                max = sum;
                rs.clear();
                rs.add(i);
            }
            sum = Math.max(sum, 0);
        }
        System.out.println(rs);
        return max;
    }

    public static int maxSubArrV2(int[] arr){
        if(arr == null || arr.length < 1) return 0;
        int max = Integer.MIN_VALUE, sum = 0, min_sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            max = Math.max(max, sum - min_sum);
            min_sum = Math.min(min_sum, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int []t = new int[]{-2,1,-3,4,-1,2,1,-1,1, -10};
        System.out.println(MaxSubArr.maxSubArr(t));
        System.out.println(MaxSubArr.maxSubArrV2(t));
    }
}
