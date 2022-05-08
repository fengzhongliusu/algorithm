package leetcode;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cshuo on 2021/8/6
 */
public class LC229 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2, 2, 1, 3}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                cnt1 += 1;
            } else if (nums[i] == num2) {
                cnt2 += 1;
            } else if (cnt1 == 0) {
                num1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                num2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1 -= 1;
                cnt2 -= 1;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int n : nums) {
            if (n == num1) cnt1 += 1;
            else if (n == num2) cnt2 += 1;
        }
        if (cnt1 > nums.length / 3) result.add(num1);
        if (cnt2 > nums.length / 3) result.add(num2);
        return result;
    }

}
