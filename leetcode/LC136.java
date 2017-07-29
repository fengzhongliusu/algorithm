package leetcode;

/**
 * Created by cshuo on 2017/7/21
 */
public class LC136 {
    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     * 考虑异或性质，将所有元素进行^操作，得到的结果即是只出现一次的数字；
     * @return
     */
    public int singleNumber(int[] nums) {
        int rs = 0;
        for(int e: nums) rs ^= e;
        return rs;
    }
}
