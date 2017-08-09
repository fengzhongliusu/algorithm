package leetcode;

/**
 * Created by cshuo on 2017/8/8
 * Given an integer, write a function to determine if it is a power of two.
 */
public class LC231 {
    public static void main(String[] args) {
    }

    /**
     * 不断左移，判断最后是否是2，且最后一位不能是1.
     */
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n <=0) return false;
        while(n != 2 && n != 0) {
            if((n&1) == 1) return false;
            n >>= 1;
        }
        return n == 2;
    }

    /**
     * 2的幂次的二进制表示中只能有一个1.
     */
    public boolean cheatMethod(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
