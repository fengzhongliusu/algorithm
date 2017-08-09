package leetcode;

/**
 * Created by cshuo on 2017/8/8
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?
 */
public class LC190 {
    /**
     * O(1)时间
     */
    public int reverseBits(int n) {
        int i = 0, rs=0;
        while(i++ < 32) {
            rs = (rs<<1)+(n&1);
            n >>= 1;
        }
        return rs;
    }
}
