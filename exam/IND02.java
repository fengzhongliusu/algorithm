package exam;

/**
 * author: cshuo
 * date: 2017/5/27
 * version: 1.0
 * description:
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IND02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), T = in.nextInt();
        int[][] abc = new int[T][3];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 3; j++) {
                abc[i][j] = in.nextInt();
            }
            Arrays.sort(abc[i]);
        }

        int[][] m = new int[T + 2][N + 1];
        for (int i = 0; i < T + 2; i++) {
            for (int j = 0; j < N + 1; j++)
                m[i][j] = 0;
        }
        for (int i = T - 1; i >= 0; i--) {
            for (int j = 1; j < N + 1; j++) {
                int tmp;
                m[i][j] = m[i+1][j];
                if(j >= abc[i][0]) {
                    tmp = 1 + m[i+1][j - abc[i][0]];
                    m[i][j] = Math.max(m[i][j], tmp);
                }
                if(j >= abc[i][0] + abc[i][1]) {
                    tmp = 2 + m[i + 1][j - abc[i][0] - abc[i][1]];
                    m[i][j] = Math.max(m[i][j], tmp);
                }
                if(j >= abc[i][0] + abc[i][1] + abc[i][2]) {
                    tmp = 3 + m[i + 1][j - (abc[i][0] + abc[i][1] + abc[i][2])];
                    m[i][j] = Math.max(m[i][j], tmp);
                }

            }
        }
        System.out.println(m[0][N]);
    }

    public static int getMax(int[][] orders, int N, int k){
        List<List<Integer>> rs = subsets(orders[k]);
        if(k == orders.length-1) {
            int max = -1;
            for(List l: rs){
                if(sum(l) <= N){
                    if(l.size() > max) max = l.size();
                }
            }
            return max;
        }
        return 0;
    }

    public static int sum(List<Integer> l){
        int sum = 0;
        for(int ele: l)
            sum += ele;
        return sum;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        addSubset(rs, new ArrayList<Integer>(), nums, 0);
        return rs;
    }

    public static void addSubset(List<List<Integer>> result, List<Integer> set, int[] nums, int start){
        result.add(new ArrayList<Integer>(set));
        for(int i=start; i<nums.length; i++){
            set.add(nums[i]);
            addSubset(result, set, nums, i+1);
            set.remove(set.size()-1);
        }
    }
}
