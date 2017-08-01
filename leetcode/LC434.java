package leetcode;

/**
 * Created by cshuo on 2017/7/25
 *
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5

 */
public class LC434 {
    public int countSegments(String s) {
        if(s == null) return 0;
        int counts = 0, preChar = 0;
        for(int i=0; i<s.length(); i++) {
            if(preChar == 0 && s.charAt(i) != ' '){
                counts++;
                preChar = 1;
            }
            else if(s.charAt(i) == ' ') preChar = 0;
        }
        return counts;
    }
}
