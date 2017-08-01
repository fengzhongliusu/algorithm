package leetcode;

/**
 * Created by cshuo on 2017/7/25
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 即子串needle第一次在母串中出现的位置；
 */
public class LC28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
