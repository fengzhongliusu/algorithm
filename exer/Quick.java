package exer;

import java.util.*;

import static leetcode.FirstMissPositive.swap;

/**
 * Created by cshuo on 2021/8/29
 */
public class Quick {
    static Map<String, String> map =new HashMap<>();

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1,3,7,5,-1,0};
        sortxx(arr, 0, arr.length - 1);
        for (int e: arr) System.out.print(e + ",");
    }

    public static void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition2(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, arr.length - 1});
        while (!stack.isEmpty()) {
            int[] ctx = stack.pop();
            int p = practice(arr, ctx[0], ctx[1]);
            if (ctx[0] < p -1) {
                stack.push(new int[]{ctx[0], p - 1});
            }
            if (p + 1 < ctx[1]) {
                stack.push(new int[]{p+1, ctx[1]});
            }
        }
    }

    private static int partition(int[] a, int low, int hi){
        int i = low, j = hi+1;
        while (true){
            while(a[++i] <= a[low]){
                if(i==hi) break;
            }
            while(a[--j] >= a[low]){
                if(j==low) break;
            }
            if(i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    private static int partition2(int[] a, int low, int hi){
        int tmp = a[low];
        while(low < hi){
            while(low < hi && a[hi] >= tmp) hi--;
            a[low] = a[hi];
            while(low < hi && a[low] <= tmp) low++;
            a[hi] = a[low];
        }
        a[low] = tmp;
        return low;
    }

    private static int practice(int[] a, int l, int r) {
        int tmp = a[l];
        while (l < r) {
            while (l < r && a[r] >= tmp) r--;
            a[l] = a[r];
            while (l < r && a[l] <= tmp) l++;
            a[r] = a[l];
        }
        a[l] = tmp;
        return l;
    }

    public static void sortxx(int[] a, int l, int r) {
        if (l >= r) return;
        int p = practice(a, l, r);
        sortxx(a, l, p - 1);
        sort(a, p + 1, r);
    }
}
