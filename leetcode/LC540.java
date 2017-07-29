package leetcode;

/**
 * Created by cshuo on 2017/7/21
 */
public class LC540 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1, 2, 3,3};
        System.out.println(singleNonDuplicate(arr));
    }

    /**
     * 二分法，过程中判断l, r位置的移动。
     */
    public int mySolution(int[] nums) {
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        int l = 0, r = nums.length - 1, mid;
        while(l <= r) {
            mid = l + (r-l) / 2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            if(nums[mid] == nums[mid+1] && mid % 2 == 0) l = mid + 1;
            else if (nums[mid] == nums[mid-1] && mid % 2 == 1) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    /**
     * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

     Example 1:
     Input: [1,1,2,3,3,4,4,8,8]
     Output: 2
     Example 2:
     Input: [3,3,7,7,10,11,11]
     Output: 10
     */
    public static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end-start) / 2;
            // 找到index为偶数的位置
            if (mid % 2 == 1) mid--;
            // 不等的话，single定在mid前;
            if (nums[mid] != nums[mid + 1]) end = mid;
            // 这对数相等，则single肯定在mid后;
            else start = mid + 2;
        }
        return nums[start];
    }
}
