package exam;

import java.util.*;

/**
 * Created by cshuo on 2017/9/10
 */
public class DDXZ01 {
    static class Interval {
        int l, r;
        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++) nums[i] = in.nextInt();
            System.out.println(getMax(nums));
        }
    }

    public static int getMax(int[] nums) {
        List<Interval> ls = new ArrayList<>();
        int xor;
        for(int i=nums.length-1; i>=0; i--) {
            xor = 0;
            for(int j=i; j>=0; j--) {
                xor ^= nums[j];
                if(xor == 0) {ls.add(0, new Interval(j, i)); break;}
            }
        }

        if(ls.size() == 0) return 0;
        int end = ls.get(0).r;
        int count = 1;
        for(int i=1; i<ls.size(); i++) {
            if(ls.get(i).l > end) {
                end = ls.get(i).r;
                count++;
            }
        }
        return count;
    }
}
