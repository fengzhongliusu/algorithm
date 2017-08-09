package leetcode;

/**
 * Created by cshuo on 2017/8/8
 *
 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 Now your job is to find the total Hamming distance between all pairs of the given numbers.

 Example:
 Input: 4, 14, 2
 Output: 6

 Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 showing the four bits relevant in this case). So the answer will be:
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 */
import java.util.*;

public class LC477 {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        Iterator<Integer> itr = test.iterator();
        while(itr.hasNext()) {
            Integer it = itr.next();
            System.out.println(it);
            itr.remove();
        }
        System.out.println(test);
    }
    /**
     * 暴力法，通过异或计算两两数字的海明距离, 复杂度较高.
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for(int i = 0; i<nums.length-1; i++)
            for(int j=i+1; j<nums.length; j++) {
                int xor = nums[i]^nums[j];
                total += Integer.bitCount(xor);
            }
        return total;
    }

    /**
     * Time: O(n)解法，对32个bit位，分别统计有多少个数字在该位上是1，然后即可计算在该位置上总的海明距离;
     * Tip:设计到数字的bit位时，都可以向32个bit位思路靠拢，复杂度O(1)；
     */
    public int totalHDis(int[] nums) {
        int total = 0, count;
        for(int i=0; i<32; i++) {
            count = 0;
            for(int e: nums)
                if((e&1<<i) != 0) count++;
            total += count * (nums.length-count);
        }
        return total;
    }
}
