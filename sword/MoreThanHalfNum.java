package sword;
import java.util.*;


/**
 * author: cshuo
 * date: 2017/7/7
 * version: 1.0
 * description:
 */
public class MoreThanHalfNum {
    /**
     * 利用hashmap统计所有数字的出现情况, 遍历map,找出出现次数大于数组长度一般的数字.
     * O(n), 空降开销大.
     * @param array
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for(int ele: array) {
            if(!nums.containsKey(ele)) {
                nums.put(ele, 0);
            }
            nums.put(ele, nums.get(ele)+1);
        }

        for(Map.Entry<Integer, Integer> entry: nums.entrySet()) {
            if(entry.getValue() > array.length / 2)
                return entry.getKey();
        }
        return 0;
    }

    /**
     * 打擂法, 目标数字出现次数比其他数字都多, 那么可以设置两个变量,一个记录数字,另一个记录该数字出现次数;
     * 比较过程如下: 如果下个数字与保存的数字相同, 则次数加1; 不相同,则次数减1; 若次数减为0, 则将数字替换成
     * 新的数字, 次数重置为1; 若果存在一个数字出现次数大于数组长度一半, 那么最后保存的数字一定是该数字,
     * 这是必要条件, 所以最后还需要验证一下是否确实大于长度一半.
     */
    public static int moreThanHalf(int[] array){
        if(array.length < 1) return 0;
        int cnt = 1, candi = array[0];
        for(int i=1; i < array.length; i++) {
            if(cnt == 0 || candi == array[i]) {
                candi = array[i];
                cnt++;
            } else if (candi != array[i]) {
                cnt-- ;
            }
        }
        cnt = 0;
        for(int ele: array)
            if(ele == candi) cnt++;
        return cnt*2 > array.length ? candi : 0;
    }
}
