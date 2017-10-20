package exam;

import java.util.Scanner;

public class TTT002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt(), x = in.nextInt();
            int[] nums = new int[n];
            int min = Integer.MAX_VALUE, minIdx = -1;
            for(int i=0; i<n; i++) {
                nums[i] = in.nextInt();
                if(nums[i] < min) {
                    min = nums[i];
                    minIdx = i;
                }
            }
            int count = 0;
            if(minIdx > x) {
                for(int i = x; i <= minIdx; i++) {
                    nums[i] -= min;
                    count += min;
                }
                for(int i = minIdx+1; i < n+x; i++) {
                    nums[i % n] -= min+1;
                    count += min+1;
                }
            } else {
                for(int i = x; i <= n + minIdx; i++) {
                    nums[i % n] -= min;
                    count += min;
                }
                for(int i = minIdx + 1; i<=x; i++) {
                    nums[i] -= min+1;
                    count += min+1;
                }
            }
            for(int i=0; i<n; i++) {
                if(i == minIdx) {
                    System.out.println(count);
                } else {
                    System.out.print(nums[i] + " ");
                }
            }
        }
        in.close();
    }
}
