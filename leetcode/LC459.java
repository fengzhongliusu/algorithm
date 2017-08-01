package leetcode;

/**
 * Created by cshuo on 2017/7/25
 */
public class LC459 {
    public static void main(String[] args) {
        String s = "abadacabadac" + (5 - 4);
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 找到与第一字符相同的字符位置，向后判断对应长度子串是否是跟第一段子串相等，都相等的话，返回true;
     */
    public static boolean repeatedSubstringPattern(String s) {
        int l=0, end = 1;
        while(end < s.length()) {
            while(end < s.length() && s.charAt(end++) != s.charAt(0));
            int pLen = --end;

            while(end <= s.length()) {
                if(!s.substring(l, end).equals(s.substring(0, pLen))) break;
                l += pLen;
                end += pLen;
            }

            if(l == s.length()) return true;

            end = pLen + 1;
            l = 0;
        }
        return false;
    }
}
