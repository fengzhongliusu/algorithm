package leetcode;

/**
 * Created by cshuo on 2017/7/25
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.

 */
public class LC125 {
    /**
     * @param s
     * 两个指针头尾开始中间夹逼；
     */
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) return true;
        s = s.toLowerCase();
        int l = 0, r = s.length()-1;
        while(l < r) {
            while(l < s.length() && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(r > -1 && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(l >= r) break;
            if(s.charAt(r) != s.charAt(l)) return false;
            l++;
            r--;
        }
        return true;
    }
}
