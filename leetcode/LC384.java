package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by cshuo on 2021/8/28
 */
public class LC384 {
    private Integer[] nums;
    private Random rnd;

    public static void main(String[] args) {
        LC384 test = new LC384(new int[] {1,2,3});
        test.reset();
        test.shuffle();
    }

    public LC384(int[] nums) {
        this.nums = new Integer[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            this.nums[i] = nums[i];
        }
        rnd = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] rs = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            rs[i] = nums[i];
        }
        return rs;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> origin = new ArrayList<>(Arrays.asList(nums));
        int[] rs = new int[origin.size()];
        int curIdx = 0;
        while (origin.size() > 0) {
            int rndIdx = rnd.nextInt(origin.size());
            rs[curIdx++] = origin.get(rndIdx);
            origin.remove(rndIdx);
        }
        return rs;
    }

}
