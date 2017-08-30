package leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LC14 {
    /**
     * end 记录已经比较过的字符串中的最长公共前缀.
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) return "";
        int end = strs[0].length();

        for(int i=0; i<strs.length; i++) {
            // 当前字符串比前面的公共前缀长度还小.
            if(strs[i].length() < end) end = strs[i].length();
            // 开始比较.
            int j = 0;
            while(j<end && strs[i].charAt(j) == strs[0].charAt(j)) j++;
            end = j < end ? j:end;
        }
        return strs[0].substring(0, end);
    }
}
