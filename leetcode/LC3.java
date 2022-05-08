package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cshuo on 2021/7/6
 */
public class LC3 {
    public static void main(String[] args) {
        LC3 test = new LC3();
        System.out.println(test.lengthOfLongestSubstring("abbac"));
    }

    /**
     * 基本 DP 思路:
     * - dp[i] 以 i 结尾的 longest distinct substring
     */
    public int lengthOfLongestSubstring_v1(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < s.length(); i++) {
            int j = i - 1;
            for (; j >= i - dp[i-1]; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i] = i - j;
                    break;
                }
            }
            if (j < i - dp[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            max = max > dp[i] ? max : dp[i];
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        Map<Character, Integer> mem = new HashMap<>();
        int prevDp = 0;
        int max = prevDp;

        for (int i = 0; i < s.length(); i++) {
            Integer prevIdx = mem.get(s.charAt(i));
            if (prevIdx != null && prevIdx >= i - prevDp) {
                // char_i appear in longest substr end with i-1
                prevDp = i - prevIdx;
            } else {
                // char_i not appear
                prevDp = prevDp + 1;
            }
            max = max > prevDp ? max : prevDp;
            // update mem
            mem.put(s.charAt(i), i);
        }

        return max;
    }

    public int v3(String s) {
        if(s.length() == 0) return 0;
        int max = 0, be = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
                be = Math.max(be, map.get(s.charAt(i))+1);
            map.put(s.charAt(i), i);
            max = Math.max(max, i-be+1);
        }
        return max;
    }

    public int v4(String s) {
        Map<Character, Integer> mem = new HashMap<>();
        int begin = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer idx = mem.get(s.charAt(i));
            if (idx != null) {
                begin = Math.max(begin, idx + 1);
            }
            max = Math.max(max, i - begin + 1);
            mem.put(s.charAt(i), i);
        }
        return max;
    }
}
