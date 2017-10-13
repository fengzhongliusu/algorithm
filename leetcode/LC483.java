package leetcode;

import java.math.BigInteger;

public class LC483 {
    public static void main(String[] args) {
        System.out.println(smallestGoodBase("16035713712910627"));
    }

    /**
     * NOTE: WRONG;
     */
    public static String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        long maxExp = (long)(Math.log(num)/Math.log(2));
        for(long i=maxExp; i>1; i--) {
            long k = (long)(Math.pow(num, 1.0/i));
            if((long)((Math.pow(k,i+1)-1)/(k-1)) == num) return Long.toString(k);
                return Long.toString(k);
        }
        return Long.toString(num-1);
    }
}
