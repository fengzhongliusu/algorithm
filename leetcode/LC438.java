package leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cshuo on 2021/10/6
 * "acdcaeccde"
 * "c"
 */
public class LC438 {
    public static void main(String[] args) {
        LC438 test = new LC438();
        List<Integer> res =
        test.findAnagrams("acdcaeccde", "c");
        System.out.println(res);
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for (Character c: p.toCharArray()) {
            map[c-'a'] += 1;
        }
        int begin = 0;
        while (begin <= s.length() - p.length()) {
            int i = 0;
            int[] tmp = Arrays.copyOf(map, map.length);
            for (; i < p.length(); i++) {
                int idx = s.charAt(begin + i) - 'a';
                if (tmp[idx] == 0) break;
                tmp[idx] -= 1;
            }
            if (i == p.length()) res.add(begin);
            begin++;
        }
        return res;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];
        for (Character c: p.toCharArray()) {
            map[c-'a'] += 1;
        }
        int[] back = Arrays.copyOf(map, map.length);
        int begin = 0, cur = 0;
        while (begin <= s.length() - p.length()) {
            while (cur < s.length() && cur - begin < p.length()) {
                int idx = s.charAt(cur) - 'a';
                if (map[idx] == 0) break;
                map[idx]--;
                cur++;
            }
            if (cur - begin == p.length()) res.add(begin);
            if (back[s.charAt(begin) - 'a'] > 0) map[s.charAt(begin) - 'a'] += 1;
            begin++;
            if (begin > cur) cur = begin;
        }
        return res;
    }

}
