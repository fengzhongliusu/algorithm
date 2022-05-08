package leetcode;

/**
 * Created by cshuo on 2021/7/20
 */
public class LC33 {
    public static void main(String[] args) {
        System.out.println(search1(new int[] {6,7,8,9,0,1}, 6));
    }

    public static int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }

    public static int bs(int[] nums, int start, int end, int target) {
        if (end < start) return -1;
        if (start == end) return nums[start] == target ? start : -1;

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[end] > nums[mid]) {
            if (target > nums[end] || target < nums[mid]) {
                return bs(nums, start, mid - 1, target);
            } else {
                return bs(nums, mid + 1, end, target);
            }
        } else {
            if (target > nums[mid] || target <= nums[end]) {
                return bs(nums, mid + 1, end, target);
            } else {
                return bs(nums, start, mid - 1, target);
            }
        }
    }

    public static int search1(int[] nums, int target) {
        int mid, l = 0, r = nums.length - 1;
        while (l <= r) {
            if (l == r) return nums[l] == target ? l : -1;

            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            if (nums[r] > nums[mid]) {
                if (target > nums[r] || target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] || target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
