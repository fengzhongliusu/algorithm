package exam;

import java.util.Scanner;

public class MT01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            long[] nums = new long[n];
            for(int i=0; i<n; i++) nums[i] = in.nextLong();
            System.out.println(getNum1(nums));
        }
        in.close();
    }

    static int getNum(long[] nums) {
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                long t = Long.parseLong(nums[i] + ""+ nums[j]);
                if(t % 7 == 0) count++;
                t = Long.parseLong(nums[j] + ""+ nums[i]);
                if(t % 7 == 0) count++;
            }
        }
        return count;
    }

    /** O(n)解法.
     * */
    public static long fuck(int x, int y) {
        long rs = x;
        while(y-- >0) rs *= 10;
        return rs;
    }

    public static int getLen(long x) {
        if(x == 0) return 1;
        int ans = 0;
        while(x > 0) {
            x /= 10;
            ans++;
        }
        return ans;
    }

    public static long getNum1(long[] nums) {
        long ans = 0;
        int[] mod = new int[7];
        for(long e: nums) mod[(int)(e%7)]++;
        for(long e: nums) {
            mod[(int)e%7]--;
            for(int i=0; i<7; i++) {
                int tmp = getLen(e);
                long n = fuck(i, tmp) + e;
                if(n%7 == 0) ans += mod[i];
            }
            mod[(int)e%7]++;
        }
        return ans;
    }
}
