package sword;

/**
 * author: cshuo
 * date: 2017/5/6
 * version: 1.0
 * description:
 */
public class MaxSubArr {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(nums));
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum=0, max = Integer.MIN_VALUE;
        for(int e: array){
            sum += e;
            max = Math.max(max, sum);
            sum = Math.max(0, sum);
        }
        return max;
    }
}
