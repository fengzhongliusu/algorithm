package sword;

/**
 * author: cshuo
 * date: 2017/7/23
 * version: 1.0
 * description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字
 * 重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}, 返回2或3。
 */
public class DuplicateNum {
    public static void main(String[] args) {
        int[] arr = new int[] {0,5,2,4,2,1,5};
        int[] rs = new int[1];
        System.out.println(dupliate(arr, arr.length, rs));
        System.out.println(rs[0]);
    }

    /**
     * 此类限定元素大小小于N的,一般考虑从元素与对应下表关系; 可以对应替换,也可以对对应位置上的数操作(*-1之类).
     */
    public static boolean dupliate(int[] numbers, int length, int[] duplication) {
        if(numbers == null || numbers.length < 2) return false;
        for(int i=0; i<length; i++) {
            if(numbers[i] < 0 || numbers[i] >= length) return false;
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
}
