package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/7/27
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 */
public class LC350 {
    public static void main(String[] args) {
    }

    /**
     * 排序方法, 指针移动.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;
        if(nums1.length < 1 || nums2.length < 1) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        ArrayList<Integer> rs = new ArrayList<>();
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] == nums2[j]) {
                rs.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] ans = new int[rs.size()];
        for(i=0; i<rs.size(); i++)
            ans[i] = rs.get(i);
        return ans;
    }

    /**
     * Hash方法，时间O(m+n), 空间:O(m)
     */
    public int[] inter(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int e: nums1) map.put(e, map.getOrDefault(e, 0) + 1);
        for(int e: nums2)
            if(map.getOrDefault(e, -1) > 0) {
                ans.add(e);
                map.put(e, map.get(e) -1);
            }
        int[] rs = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
            rs[i] = ans.get(i);
        return rs;
    }
}
