package leetcode;
import java.util.*;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class LC560 {
    /**
     * 思路：使用前缀和+map, key: 前缀和，value: 等于某个值的前缀和的个数.
     * 迭代到某个元素得到前缀和 - k 若存在在map中，说明中间必有一段子串的和为k, 累加到count中;
     * 注意，开始时需要put(0, 1)来确保第一段不被漏掉.
     */
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);
        for(int e: nums) {
            sum += e;
            count += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * 扩展：找到一个数组中所有异或值为0的子数组, 思路与和为k的子数组基本相同；不同的是map中value不是个数了，而是等于异或值等于某个值的
     * 对应下表的集合.
     */
    public static List<int[]> subArrayXor(int[] nums) {
        List<int[]> rs = new ArrayList<>();
        if(nums == null || nums.length < 1) return rs;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int xor = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
            List<Integer> tmp = map.getOrDefault(xor, new ArrayList<>());
            if(tmp.size() > 0) rs.add(new int[] {tmp.get(tmp.size()-1) + 1, i});
            tmp.add(i);
            map.put(xor, tmp);
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,2,2,3,3,3,0,4,4,4,0};
        List<int[]> rs = subArrayXor(nums);
        for(int[] e : rs) System.out.println(e[0] + " " + e[1]);
    }
}
