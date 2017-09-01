package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by cshuo on 2017/8/2
 * 字符串表示的大整数相乘，结果返回字符串。
 */
public class LC43 {
    /**
     * 思路：模拟乘法竖式计算过程，num1[i]与num2[j]乘积结果放在结果数组的[i+j, i+j+1]的位置.
     */
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "38383838";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        int m = num1.length(), n = num2.length();
        int[] rs = new int[m+n];

        int mlt, p1, p2;
        for(int i=m-1; i>=0; i--)
            for(int j=n-1; j>=0; j--) {
                mlt = (num1.charAt(i)-'0') *(num2.charAt(j)-'0');
                p1 = i + j;
                p2 = i + j + 1;
                rs[p1] += (mlt+rs[p2]) / 10;    // 操作之后rs[p1]是可能大于9的，但是会被之后迭代的下一行求余操作变成小于10.
                rs[p2] = (mlt+rs[p2]) % 10;
            }
        StringBuilder sb = new StringBuilder();
        for(int e: rs) {
            // 0开头的结果，0不能放入sb.
            if(sb.length() > 0 || e != 0) sb.append(e);
        }
        return sb.length()==0? "0":sb.toString();
    }
}
