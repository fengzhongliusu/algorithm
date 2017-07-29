package leetcode;

/**
 * Created by cshuo on 2017/7/25
 */
public class LC58 {
    public int lengthOfLast(String s) {
        if(s == null) return 0;
        int count = 0, lastCount = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ' && count > 0) {
                lastCount = count;
                count = 0;
            }
            else if(s.charAt(i) != ' ') count++;
        }
        return count == 0 ? lastCount:count;
    }
    /**
     * in advantage of java characteristics.
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
}
