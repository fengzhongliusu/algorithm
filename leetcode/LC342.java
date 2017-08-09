package leetcode;

/**
 * Created by cshuo on 2017/8/8
 * 判断是否是4的幂次;
 */
public class LC342 {
    public static void main(String[] args) {
    }
    /**
     * 4的幂次中1的位置总是在奇数位置上，所以有两种解法
     * 1. 与0x55555555相与；
     * 2. 减一模3 (1在奇数位置上，减一后有偶数个1，最少的偶数个1是0b11(3));
     */
    public boolean isPowerOfFour(int n) {
//        return n >0 && (n&(n-1))==0 && (n&0x55555555) != 0;
        return n >0 && (n&(n-1))==0 && (n-1)%3 ==0;
    }
}
