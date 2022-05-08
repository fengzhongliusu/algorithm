package leetcode;

/**
 * Created by cshuo on 2021/7/22
 */
public class LC704 {
    public int search(int[] nums, int target) {
        int mid, l = 0, r = nums.length -1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
