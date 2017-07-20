package leetcode;
import java.util.*;

/**
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon
 * subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be
 * any subsequence of the other strings.

 A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the
 order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

 The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence.
 If the longest uncommon subsequence doesn't exist, return -1.

 Example 1:
 Input: "aba", "cdc", "eae"
 Output: 3
 */

public class LC522{
    /**
     * 思路: Hashmap 统计词频，抽取keys, 按照key的长度排序，从大到小，判断该词是否只出现一次，如果最长的词语只出现一次，则结果是其长度；
     * 对于长度不是最大的词语，除了判断其词频是否为1外，还要判断它是否是比他长的词语的子序列；
     */
    public int findLUSlength(String[] strs) {
        if(strs.length < 1) return -1;

        HashMap<String, Integer> map = new HashMap<>();
        for(String str: strs) {
            if(!map.containsKey(str)) map.put(str, 0);
            map.put(str, map.get(str)+1);
        }

        String[] keys = map.keySet().toArray(new String[map.size()]);
        Arrays.sort(keys, (o1, o2) -> o2.length() - o1.length());
        int max_len = keys[0].length();

        for(int i=0; i<keys.length; i++) {
            if(keys[i].length() == max_len && map.get(keys[i]) == 1)
                return max_len;
            if(keys[i].length() < max_len && map.get(keys[i]) == 1) {
                int j = 0;
                for(; j < i; j++) {
                    if(isSubseq(keys[i], keys[j])) break;
                }
                if (j == i) return keys[i].length();
            }
        }

        return -1;
    }

    public boolean isSubseq(String a, String b) {
        if(a.length() > b.length()) return false;
        int i=0, j=0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }
}
