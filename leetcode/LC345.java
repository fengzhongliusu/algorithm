package leetcode;

/**
 * Created by cshuo on 2017/7/25
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class LC345 {
    /**
     * 思路：两个指针分别头尾向中间扫描;
     */
    public String reverseVowels(String s) {
        if(s == null) return s;
        char[] rs = new char[s.length()];
        int l = 0, r = s.length() - 1;
        String vowels = "aeiouAEIOU";
        while(l <= r) {
            while(l < s.length() && vowels.indexOf(s.charAt(l)) == -1) rs[l] = s.charAt(l++);
            while(r > -1 && vowels.indexOf(s.charAt(r)) == -1) rs[r] = s.charAt(r--);
            if(l > r) break;
            rs[l] = s.charAt(r);
            rs[r] = s.charAt(l);
            l++; r--;
        }
        return new String(rs);
    }
}
