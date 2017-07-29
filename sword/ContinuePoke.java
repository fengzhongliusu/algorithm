package sword;

/**
 * author: cshuo
 * date: 2017/7/23
 * version: 1.0
 * description: 给定5张牌判断是否是顺子, 大小王可变任意牌;
 */
import java.util.*;

public class ContinuePoke {
    public static void main(String[] args) {
        int[] arr = new int[]{0,3,2,6,4};
        System.out.println(isContinuous(arr));
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        Arrays.sort(numbers);
        int count = -1, sign = 0;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 0) continue;
            if(i<numbers.length-1 && numbers[i] == numbers[i+1]) return false;
            if(sign == 0) {
                count = i;
                sign = 1;
            }
        }
        return count == -1 || Math.abs(numbers[4] - numbers[count]) < 5;
    }
}
