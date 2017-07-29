package leetcode;

/**
 * Created by cshuo on 2017/7/25
 * you are given a string representing an attendance record for a student. The record only contains the following three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True
 Example 2:
 Input: "PPALLL"
 Output: False
 */
public class LC551 {

    public boolean checkRecord(String s) {
        if(s == null) return true;
        int countA = 0, countL = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'A') {
                countA++;
                if(countA > 1) return false;
            }
            if(s.charAt(i) == 'L'){
                countL++;
                if(countL > 2) return false;
            }
            else countL = 0;
        }
        return true;
    }

    public boolean solution1(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

    public boolean solution2(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }

}
