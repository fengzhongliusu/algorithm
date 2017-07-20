package hiho;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/7/19
 * version: 1.0
 * description:
 */
public class MS01 {
    private static int[] sum;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len+1];
        int counts = 0;

        if(len < 3){
            System.out.println(0);
            return;
        }

        sum = new int[len+1];
        for(int i = 1; i<= len; i++)
            nums[i] = in.nextInt();
        calPreSum(nums);

        for(int i = 1; i<len-1; i++) {
            if(sum[i] * 3 > sum[len] + 3) continue;
            for(int j = i+1; j<len; j++) {
                if(Math.abs(sum[j]-2*sum[i]) < 2 && Math.abs(sum[len] - sum[i] - sum[j]) < 2 && Math.abs(sum[len]-2*sum[j] + sum[i]) < 2)
                    counts ++;
            }
        }
        System.out.println(counts);
        in.close();
    }

    public static void calPreSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }
}
