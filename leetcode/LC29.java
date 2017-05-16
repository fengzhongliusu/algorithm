package leetcode;

/**
 * author: cshuo
 * date: 2017/4/17
 * version: 1.0
 * description:
 */
public class LC29 {
    public static int divide(int dividend, int divisor) {
        int sign = 0;
        if(dividend>0 && divisor<0) sign = 1;
        if(dividend<0 && divisor>0) sign = 1;
        if(divisor == 0) return Integer.MAX_VALUE;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int sum = 0, count = 0;
        while(sum < dividend){
            sum += divisor;
            count++;
        }
        if(sum == dividend) return sign == 0?count:-count;
        else return sign == 0?count-1:1-count;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
