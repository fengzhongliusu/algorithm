package leetcode;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
 * one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.

 Given an array nums representing the data status of this set after the error.
 Your task is to firstly find the number occurs twice and then find the number that is missing.
 Return them in the form of an array.

 Example 1:
 Input: nums = [1,2,2,4]
 Output: [2,3]

 */
public class LC645 {
    /**
     * onePass的解法，首先将元素值作为下标将对应位置的元素取负，若发现某个元素取负之后成为正数，那么它就是duplicated，然后根据求和公式
     * 跟当前数组之后计算下即可得到缺失的数字.
     */
    public int[] findErrorNums(int[] nums) {
        int[] rs = new int[2];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += Math.abs(nums[i]);
            nums[Math.abs(nums[i])-1] = - nums[Math.abs(nums[i])-1];
            if(nums[Math.abs(nums[i])-1] > 0) rs[0] = Math.abs(nums[i]);
        }
        rs[1] = nums.length*(nums.length+1)/2 + rs[0] - sum;
        return rs;
    }
}
