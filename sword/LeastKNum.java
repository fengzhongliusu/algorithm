package sword;

/**
 * author: cshuo
 * date: 2017/7/10
 * version: 1.0
 * description:
 */

import java.util.*;

public class LeastKNum{

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,9,1,0,7};
        ArrayList<Integer> rs = GetLeastNumbers_Solution(nums, 6);
        for (int e: rs)
            System.out.print(e + " ");
    }


    /**
     * 使用快排的partition思想, 迭代找到位置为k-1的pivot, 其之前的数字就是要求的最小的k个数字.
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0, hi = input.length - 1, split = -1;

        if(k > hi + 1) return result;

        while(split != k-1) {
            split = partition(input, low, hi);
            if(split < k-1) low = split + 1;
            else if(split > k-1) hi = split - 1;
        }

        for(int i = 0; i < k; i++)
            result.add(input[i]);
        Collections.sort(result);
        return result;
    }

    /**
     * 快排的partition操作.
     */
    public static int partition(int[] a, int low, int hi){
        int tmp = a[low];
        while(low < hi){
            while(low < hi && a[hi] >= tmp) hi--;
            a[low] = a[hi];
            while(low < hi && a[low] <= tmp) low++;
            a[hi] = a[low];
        }
        a[low] = tmp;
        return low;
    }
}
