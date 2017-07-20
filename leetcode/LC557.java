package leetcode;

/**
 * author: cshuo
 * date: 2017/7/18
 * version: 1.0
 * description:
 */
public class LC557 {
    /**
     *
     * Reverse Words in a String III
     *
     * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     *
     * Example 1:
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     *
     * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     */
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuffer result = new StringBuffer();
        StringBuffer tmp = new StringBuffer();

        for(int i=0; i<words.length; i++){
            tmp.setLength(0);
            tmp.append(words[i]).reverse();
            result.append(tmp);
            if(i < words.length - 1) result.append(" ");
        }
        return result.toString();
    }
}
