package sword;
import java.util.*;

/**
 * author: cshuo
 * date: 2017/7/10
 * version: 1.0
 * description:
 */
public class FirstNotRepeat {
    /**
     * 找到一个字符串中第一个只出现一次的字符,并返回其位置;
     * O(n), 空间O(1). 使用哈希表, 两次遍历字符串, 第一次统计字符出现次数, 第二次找到第一个只出现一次的字符.
     */
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> counts = new HashMap<>();
        char[] chars = str.toCharArray();
        for(char c: chars) {
            if(!counts.containsKey(c)) counts.put(c, 0);
            counts.put(c, counts.get(c) + 1);
        }
        for(int i=0; i<chars.length; i++)
            if(counts.get(chars[i]) == 1)
                return i;
        return -1;
    }
}
