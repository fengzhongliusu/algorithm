package leetcode;

/**
 * Created by cshuo on 2017/8/1
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class LC35 {
    /**
     * 最后循环跳出条件肯定是l = r + 1, 这里肯定是 nums[r] < target < nums[l](边界只满足其中一个), 所以l即所需位置.
     */
    public int searchInsert(int[] nums, int target) {
        if(nums.length < 1) return 0;

        int mid, l = 0, r = nums.length-1;
        while(l <= r) {
            mid = (r-l)/2 + l;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) r = mid-1;
            else l = mid + 1;
        }
        return l;
    }
}
