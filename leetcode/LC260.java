package leetcode;

/**
 * Created by cshuo on 2017/7/21
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class LC260 {

    /**
     * 当数组中只有一个出现次数为1的元素时，处理方式比较简单，异或所有元素的结果就是该元素；
     * 有两个词频是1的元素时，可以考虑将数组分成两个部分，将这两个词分别分到两个数组中，即将问题规约成单个词频为1的问题了；
     * 划分方法：异或所有元素，得到的结果（必然不为0）相当于两个词频为1的元素进行异或，找到右边第一个为1的比特位置，然后遍历数组根据该位置
     * 是否为1就可将该两个元素划分到不同的数组；
     */
    public int[] singleNumber(int[] nums) {
        int[] rs = new int[2];
        int xor = 0, flag = 1;
        for(int e: nums) xor ^= e;
        while((xor&flag) == 0) flag <<= 1;
        for(int e: nums) {
            if((e&flag) == 0) rs[0] ^= e;
            else rs[1] ^= e;
        }
        return rs;
    }
}
