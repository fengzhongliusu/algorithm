package exam;

import java.util.Scanner;

public class TT02 {
    static int maxSum = Integer.MIN_VALUE;
    static int[] preSum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            preSum = new int[n+1];
            int[] nums = new int[n];
            for(int i=0; i<n; i++) {
                nums[i] = in.nextInt();
                preSum[i+1] = preSum[i] + nums[i];
            }
        }
    }

    public static void dfs(int[] nums, int l, int r) {
        if(l == nums.length-1 && r == nums.length-1) {
            if(nums[l] * nums[l] > maxSum){
                maxSum = nums[l] * nums[l];
                return;
            }
        }
        int minVal = Integer.MAX_VALUE;
        for(int i =l; i<=r; i++) if(nums[i] < minVal) minVal = nums[i];
        int tmp = minVal * (preSum[r] - preSum[l-1]);
        if(tmp > maxSum) maxSum = tmp;

    }
}
