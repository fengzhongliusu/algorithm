package leetcode;

/**
 * Created by cshuo on 2017/7/27
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least
 * one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class LC287 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 3};
        System.out.println(findDuplicate(nums));
    }

    /**
     * 类似链表找环的入口操作;
     * 0 1 2 3
     * 1 2 3 1
     * 0 -> (1,1) -> (2,2) -> (3,3) -> (1,1).
     */
    public static int findDuplicate(int[] nums) {
        if(nums.length < 1) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
