package leetcode;

import java.util.*;

/**
 * Created by cshuo on 2021/5/23
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class LC451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        Map.Entry<Character, Integer>[] entries = counter.entrySet().toArray(new Map.Entry[0]);

        Arrays.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entries.length; i++) {
            for (int k = 0; k < entries[i].getValue(); k++) {
                sb.append(entries[i].getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(frequencySort("dacc"));
    }
}
