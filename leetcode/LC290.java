package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/9/9
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.

 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class LC290 {
    /**
     * 思路: 使用HashMap记录之前匹配情况，key: pattern character, value: strings.
     */
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(strs[i])) return false;
            } else {
                if(map.containsValue(strs[i])) return false;
                map.put(c, strs[i]);
            }
        }
        return true;
    }
}
