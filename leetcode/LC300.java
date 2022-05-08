package leetcode;

import javafx.collections.transformation.SortedList;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by cshuo on 2021/8/12
 */
public class LC300 {
    public static void main(String[] args) {
        int[] a = new int[] {2,1,3};
        System.out.println(findPositionToReplace(a, 0, 2, 5));
        System.out.println(lengthOfLIS(a));
    }
    public static int findPositionToReplace(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = 0;
        for (int i: nums) {
            set.add(i);
            int numOfSmallerEle = set.headSet(i, true).size();
            if (numOfSmallerEle > max) max = numOfSmallerEle;
        }
        return max;
    }
}
