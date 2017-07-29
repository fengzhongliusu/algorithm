package sword;
import java.util.*;

/**
 * Created by cshuo on 2017/7/21
 */
public class FindOneAppearance {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 2,2,2, 3,3,3, 5,5,5};
        System.out.println(findOneFromThree(arr));
    }
    /**
     * @param array
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * cshuo: 直观解法：hashmap统计数字出现次数.
     */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int e: array) {
            if(!counts.containsKey(e)) counts.put(e, 0);
            counts.put(e, counts.get(e)+1);
        }
        int num = 0;
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            if(entry.getValue() == 1) {
                if(num == 0) num1[0] = entry.getKey();
                else num2[0] = entry.getKey();
                num += 1;
            }
        }
    }

    /**
     * 当数组中只有一个出现次数为1的元素时，处理方式比较简单，异或所有元素的结果就是该元素；
     * 有两个词频是1的元素时，可以考虑将数组分成两个部分，将这两个词分别分到两个数组中，即将问题规约成单个词频为1的问题了；
     * 划分方法：异或所有元素，得到的结果（必然不为0）相当于两个词频为1的元素进行异或，找到右边第一个为1的比特位置，然后遍历数组根据该位置
     * 是否为1就可将该两个元素划分到不同的数组；
     */
    public static void findTwoNumAppearOnce(int[] a, int num1[], int num2[]) {
        int sum = 0, counts = 0;
        for(int e: a) sum ^= e;
        while((sum&1) == 0) counts <<= 1;
        num1[0] = 0;
        num2[0] = 0;
        for(int e: a) {
            if((counts&e) == 0) num1[0] ^= e;
            else num2[0] ^= e;
        }
    }

    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     * 考虑异或性质，将所有元素进行^操作，得到的结果即是只出现一次的数字；
     * @return
     */
    public static int findOnlyOne(int[] a) {
        int rs = 0;
        for(int e: a) rs ^= e;
        return rs;
    }

    /**
     * 数组a中只有一个数出现一次，其他数都出现了3次，找出这个数字
     * 思路：使用一个bit数组，统计所有元素对应bit位置的和，再对各个位置的bit和模3, 不为0的话说明所求元素在该bit位上是1.
     */
    public static int findOneFromThree(int[] array) {
        int[] bits = new int[32];
        for(int i=0; i<array.length; i++)
            for(int j=0; j<32; j++) bits[j] += array[i] >> j & 1;

        int res = 0;
        for(int i=0; i<32; i++)
            if(bits[i] % 3 != 0) res += 1<<i;
        return res;
    }
}
