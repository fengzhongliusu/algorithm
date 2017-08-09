package leetcode;

/**
 * author: cshuo
 * date: 2017/8/5
 * version: 1.0
 * description:
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        return findKth(nums, 0, nums.length-1, index);
    }

    public int findKth(int[] nums, int l, int r, int k) {
        if(l > r) return -1;
        int p = partition(nums, l, r);
        if(p == k) return nums[p];
        else if(p > k) return findKth(nums, l, p-1, k);
        else return findKth(nums, p+1, r, k);
    }

    public int partition(int[] nums, int l, int r) {
        int tmp = nums[l];
        while(l < r) {
            while(l < r && nums[r] >= tmp) r--;
            nums[l] = nums[r];
            while(l < r && nums[l] <= tmp) l++;
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }
}
