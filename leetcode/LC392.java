package leetcode;

/**
 * Created by cshuo on 2021/7/16
 */
public class LC392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() < 1) return true;

        int s_idx = 0;
        int t_idx = 0;
        while (s_idx < s.length() && t_idx < t.length()) {
            if (s.charAt(s_idx) == t.charAt(t_idx)) {
                s_idx += 1;
                t_idx += 1;
            } else {
                t_idx += 1;
            }
        }
        return s_idx == s.length();
    }
}
