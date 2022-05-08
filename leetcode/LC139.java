package leetcode;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.util.*;

/**
 * Created by cshuo on 2021/7/19
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 *
 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
 * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class LC139 {
    public static void main(String[] args) {
        LC139 lc = new LC139();
        System.out.println(lc.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str: wordDict) {
            set.add(str);
            if (str.length() < min) min = str.length();
            if (str.length() > max) max = str.length();
        }

        return canBreak(s, 0, set, new HashMap<>());
    }

    public boolean canBreak(String s, int idx, Set<String> set, Map<Integer, Boolean> cache) {
        if (idx >= s.length()) {
            return true;
        }
        boolean ok = false;
        for (int i = idx + 1; i <= s.length(); i++) {
            if (i - idx < min || i - idx > max) continue;
            if (set.contains(s.substring(idx, i))) {
                Boolean cachedVal = cache.get(i);
                if (cachedVal == null) {
                    cachedVal = canBreak(s, i, set, cache);
                    cache.put(i, cachedVal);
                }
                ok |= cachedVal;
                if (ok) return ok;
            }
        }
        return ok;
    }
}
