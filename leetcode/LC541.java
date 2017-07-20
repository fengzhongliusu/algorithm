package leetcode;

/**
 * author: cshuo
 * date: 2017/7/18
 * version: 1.0
 * description:
 */
public class LC541 {
    /**
     * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting
     * from the start of the string. If there are less than k characters left, reverse all of them. If there are less than
     * 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
     *
     * Example:
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     * Restrictions:
     * The string consists of lower English letters only.
     * Length of the given string and k will in the range [1, 10000]
     */
    public String reverseStr(String s, int k) {
        // 记录每2k个字符, 长度达到2k-1后, 重新置零.
        int count = 0;
        StringBuilder rs = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(count < k) {
                tmp.append(s.charAt(i));
                if(count == k-1) {
                    rs.append(tmp.reverse());
                    tmp.setLength(0);
                }
            } else {
                rs.append(s.charAt(i));
            }
            if(++count == 2*k) count = 0;
        }
        // 最后一个子段长度小于k, 在此进行判断.
        if(tmp.length() > 0) rs.append(tmp.reverse());
        return rs.toString();
    }
}
