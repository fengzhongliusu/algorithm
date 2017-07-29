package sword;

/**
 * author: cshuo
 * date: 2017/7/22
 * version: 1.0
 * 找出给定有序数组中一对数满足其和为给定的sum, 若有多组,取乘积最小;
 */
import java.util.*;

public class FindNumsWithSum {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(FindNumbersWithSum(arr, 21));

    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int minMulti = Integer.MAX_VALUE;
        int l = 0, r = array.length-1, sign=0;
        Integer[] rs = new Integer[2];
        while(l < r) {
            if(array[l]+array[r] == sum && array[l]*array[r] < minMulti) {
                rs[0] = array[l++];
                rs[1] = array[r--];
                minMulti = rs[0] * rs[1];
                sign = 1;
            }
            else if(array[l]+array[r] < sum) l++;
            else if(array[l]+array[r] > sum) r--;
            else {l++; r--;}
        }
        return sign==1 ? new ArrayList<>(Arrays.asList(rs)): new ArrayList<Integer>();
    }

    /**
     * a+b = sum, a - b 越大, ab越小.
     */
    public static ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        int l = 0, r = array.length-1;
        while(l < r) {
            if(array[l]+array[r] == sum)
                return new ArrayList<>(Arrays.asList(array[l], array[r]));
            else if(array[l]+array[r] < sum) l++;
            else r--;
        }
        return new ArrayList<Integer>();
    }
}
