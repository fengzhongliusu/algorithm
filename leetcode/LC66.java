package leetcode;
import java.util.*;

/**
 * Created by cshuo on 2017/8/2
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class LC66 {
    public static void main(String[] args) {
    }

    public int[] plusOne(int[] digits) {
        int[] rs = new int[digits.length+1];
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            int sum = digits[i] + carry;
            rs[i+1] = sum % 10;
            carry = sum / 10;
        }
        if(carry == 1){
            rs[0] = 1;
            return rs;
        }
        return Arrays.copyOfRange(rs, 1, rs.length);
    }
}
