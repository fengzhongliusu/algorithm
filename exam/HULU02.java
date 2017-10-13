package exam;

import java.util.Scanner;

public class HULU02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            long m = in.nextLong(), n = in.nextLong();
            System.out.println(findKthNumber(m, n));
        }
        in.close();
    }

    public static long findKthNumber(long n, long k) {
        if(k > n) return -1;
        long cur = 1;
        k = k - 1;
        while(k > 0) {
            long steps = calSteps(n, cur, cur+1);
            if(k >= steps) {
                cur++;
                k -= steps;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    public static long calSteps(long n, long n1, long n2) {
        long count = 0;
        while(n1 <= n) {
            count += Math.min(n+1, n2) - n1;
            if(n1 > Long.MAX_VALUE / 10) break;
            n1 *= 10;
            n2 *= 10;
        }
        return count;
    }
}
