package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/9/4
 */
public class LC15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {0,0}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        int i = -1, l, r;
        while(++i < nums.length) {
            while(i < nums.length && used[i] == 1) i++;
            while(i+1 < nums.length && nums[i+1] == nums[i]) i++;
            if(i > nums.length-1) break;
            l = 0; r = nums.length-1;
            while(l < r) {
                System.out.println(l + " " + r + " " + i);
                if(l == i || r == i) {
                    l += l == i ? 1 : 0;
                    r -= r == i ? 1 : 0;
                }
                else if(nums[l] + nums[r] == -nums[i]) {
                    used[l] = 1; used[r] = 1; used[i] = 1;
                    List<Integer> e = new ArrayList<>(Arrays.asList(nums[l], nums[r], nums[i]));
                    Collections.sort(e);
                    rs.add(e);
                    l++; r--;
                }
                else if(nums[l] + nums[r] < -nums[i]) ++l;
                else --r;
            }
        }
        return rs;
    }
}
