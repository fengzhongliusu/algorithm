package leetcode;

/**
 * Created by cshuo on 2017/8/8
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 Example:
 Given a = 1 and b = 2, return 3.
 */
public class LC371 {
    /**
     * 考虑两个数字的二进制形式加减，相加时相同为0，相异为1，故为异或；然后考虑进位，递归相加；
     */
    public static void main(String[] args) {
        int i = 0x80000000;
        System.out.println(i);
        System.out.println(i>>1);
        System.out.println(i>>>1);
    }

    public int getSum(int a, int b) {
        while(b != 0) {
            int c = a&b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}
