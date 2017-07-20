package leetcode;/*
* Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/

import java.util.*;

public class LC442{
    /*
    将数字放回其自然顺序的位置，如4的index是3, 若该位置已经有对应的数字，则其是重复的数字，
    可能会对一个数字进行多次判断，用set保证唯一性。
    */
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> rs = new HashSet<>();

        for(int i=0; i<nums.length;) {
            if(nums[i] == i + 1) i++;
            else if(nums[nums[i]-1] == nums[i]) {
                rs.add(nums[i]);
                i++;
            }
            else swap(nums, i, nums[i] - 1);
        }
        return new ArrayList<Integer>(rs);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


/*********** Better ***************/
/*
public class Solution {
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
*/
