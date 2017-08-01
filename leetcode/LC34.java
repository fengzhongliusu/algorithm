package leetcode;

/**
 * Created by cshuo on 2017/8/1
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class LC34 {
    /**
     * 思路一：基于之前二分搜索的联系，找给定K的第一次出现位置和最后一次出现位置；
     */
    public int[] searchRange(int[] nums, int target) {
        int start=-1, end=-1;
        int l=0, r=nums.length-1, mid;
        while(l<=r) {
            mid = (r-l)/2+l;
            if(nums[mid] > target) r = mid-1;
            else if(nums[mid] < target) l = mid+1;
            else if(mid > 0 && nums[mid-1] == target) r = mid-1;
            else {
                start = mid;
                break;
            }
        }
        if(start == -1) return new int[]{-1,-1};

        r=nums.length-1;
        while(l<=r) {
            mid = (r-l)/2+l;
            if(nums[mid] > target) r = mid-1;
            else if(nums[mid] < target) l = mid+1;
            else if(mid < nums.length-1 && nums[mid+1] == target) l = mid+1;
            else {
                end = mid;
                break;
            }
        }
        return new int[]{start, end};
    }

    /**
     * 思路二：写一个函数，找第一个大于或等于给定数字的位置.
     */
    public  int[] findRange(int[] nums, int target) {
        int start = findFirstGreaterOrEqual(nums, target);
        if(start == nums.length || nums[start] != target) return new int[]{-1,-1};
        return new int[]{start, findFirstGreaterOrEqual(nums, target+1)-1};
    }

    public static int findFirstGreaterOrEqual(int[] nums, int target) {
        int l=0, r=nums.length, mid;
        while(l<r) {
            mid = (r-l)/2+l;
            if(nums[mid] < target) l=mid+1;
            //nums[i] == target时，结果可能是Mid, nums[i] > target时，也有可能是mid.
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,3,5,9,19};
        System.out.println(findFirstGreaterOrEqual(nums, 4));
    }
}



