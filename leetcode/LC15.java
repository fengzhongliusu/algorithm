package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/9/4
 */
public class LC15 {
    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     Note: The solution set must not contain duplicate triplets.
     For example, given array S = [-1, 0, 1, 2, -1, -4],
     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     TAG: Two pointer.
     思路: O(n^2)解法, 先排序, 从头开始将数组元素作为解的最小元素找可行解, 注意跳过重复的元素.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums == null || nums.length < 3) return rs;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int l = i+1, r = nums.length-1;
            while(l < r) {
                if(nums[l] + nums[r] == -nums[i]) {
                    rs.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l+1 < r && nums[l+1] == nums[l]) l++;
                    while(r-1> l && nums[r-1] == nums[r]) r--;
                    l++; r--;
                }
                else if(nums[l] + nums[r] < -nums[i]) l++;
                else r--;
            }
            while(i+1<nums.length-2 && nums[i+1] == nums[i]) i++;
        }
        return rs;
    }
}
