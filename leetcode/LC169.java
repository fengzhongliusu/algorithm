package leetcode;

/**
 * author: cshuo
 * date: 2017/8/5
 * version: 1.0
 *
 * description: Given an array of size n, find the majority element. The majority element is the element
 * that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class LC169 {
    /**
     * curse记录潜在的majority, count记录其出现次数, 若其后元素与curse不同则count-1, count<0的话, 就将curse替换.
     * 由于majority出现次数大于n/2,那么通过这样操作,最后curse必然是majority.
     */
    public int majorityElement(int[] nums) {
        int curse = nums[0], count = 1;
        for(int i=1; i<nums.length; i++) {
            if(curse == nums[i]) count++;
            else count--;
            if(count < 0) {
                curse = nums[i];
                count = 1;
            }
        }
        return curse;
    }
}
