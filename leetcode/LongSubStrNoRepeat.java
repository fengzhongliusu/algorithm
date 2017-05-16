package leetcode;

import java.util.HashMap;

/**
 * author: cshuo
 * date: 2017/5/10
 * version: 1.0
 * description:
 */
public class LongSubStrNoRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        // point指向当前探索子串的头部.
        int point = 0, max_len = 0;
        for(int i=0; i<s.length(); i++){
            if(mp.containsKey(s.charAt(i)) && mp.get(s.charAt(i))>=point){
                max_len = Math.max(i-point, max_len);
                // 头部更新为当前探索子串中的重复字符的后一个字符;
                point = mp.get(s.charAt(i)) + 1;
            }
            mp.put(s.charAt(i), i);
        }
        return Math.max(s.length()-point, max_len);
    }
}
