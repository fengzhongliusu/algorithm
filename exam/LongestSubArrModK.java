package exam;

import java.util.Arrays;

/**
 * 和为k的倍数的最长子串
 * 思路：前缀和 + 同余相减
 * sum[i]和sum[j]同余，那么[i+1, j]这段子串和必然是k的倍数
 * 过程: mods[]数组表示以第一个出现 sum[i]%k 为下表的存储的i值, 即mods[sum[i]%k] = i; 注意mods[0] = -1; 因为可以选择不加任何元素，
 * 此时前缀和是0.
 */
public class LongestSubArrModK{
    public static void main(String[] args) {
        int [] a = new int[] {3,1,2,7,7,7};
        System.out.println(getLongest(a, 4));
    }

    public static int getLongest(int[] nums, int k) {
        if(nums == null || nums.length < 1) return 0;
        int maxLen = 0;
        int[] mods = new int[k];
        Arrays.fill(mods, -2);
        mods[0] = -1;
        int sum = 0, mod;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            mod = sum % k;
            if(mods[mod] != -2)
                maxLen = maxLen < i - mods[mod] ? i - mods[mod] : maxLen;
            else
                mods[mod] = i;
        }
        return maxLen;
    }
}
