package leetcode;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description:
 */
public class LC343 {
    public int integerBreak(int n) {
        if(n == 2)  return 1;
        if(n == 3)  return 2;
        if(n % 3 == 0) return (int)Math.pow(3, n/3);
        if(n % 3 == 1) return 2*2*(int)Math.pow(3, (n-4)/3);
        else return 2*3*(int)Math.pow(3, (n-5)/3);
    }
}
