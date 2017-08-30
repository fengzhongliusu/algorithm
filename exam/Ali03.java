package exam;

import java.util.Arrays;

/**
 * 包含相等数目男女生的最长连续序列.
 */
public class Ali03 {
    public static void main(String[] args) {
        int[] list = new int[] {1,0,1,0,1,1,0,1};
        System.out.println(getMaxLen(list));
    }

    /**
     * dp[i]标记从某一个位置开始，向后遍历时，该段list的男女数目之差.
     */
    public static int getMaxLen(int[] list) {
        int maxNum = 0;
        int[] dp = new int[list.length+1];
        for(int i=1; i<=list.length; i++) {
            for(int j=i; j<=list.length; j++) {
                if(list[j-1] == 1) dp[j] = dp[j-1] + 1;
                else dp[j] = dp[j-1] - 1;
                if(dp[j] == 0 && j-i+1 > maxNum) maxNum = j-i+1;
            }
            Arrays.fill(dp, 0);
        }
        return maxNum;
    }
}
