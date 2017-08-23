package leetcode;

public class LC70 {
    /**
     * 爬梯子，一次一步或两步.
     * 典型DP, O(n);
     */
    public int climbStairs(int n) {
        if(n < 1) return 0;
        int[] ways = new int[n];
        ways[0] = 1;
        if(n < 2) return ways[n-1];
        ways[1] = 2;
        for(int i=2; i<ways.length; i++)
            ways[i] = ways[i-1] + ways[i-2];
        return ways[n-1];
    }
}
