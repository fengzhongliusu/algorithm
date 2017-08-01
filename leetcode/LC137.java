package leetcode;

/**
 * Created by cshuo on 2017/7/21
 * 复杂度O(32N) 即 O(N), 常数空间复杂度；
 * 统计所有元素在每个bit位置上1的个数，总数模3大于0，则所求元素在该比特位上为1；
 * 易扩展，如其他元素出现4次，则对应代码改成 sum % 4；
 */
public class LC137 {
    public int singleNumber(int[] nums) {
        int result = 0, sum = 0;
        for(int i=0; i<32; i++) {
            sum = 0;
            for(int j=0; j<nums.length; j++)
                if((nums[j]>>i&1) == 1)
                    sum += 1;
            if(sum % 3 != 0) result += 1<<i;
        }
        return result;
    }
}
