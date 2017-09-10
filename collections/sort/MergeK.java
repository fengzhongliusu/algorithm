package collections.sort;

/**
 * 合并K个有序数组
 * 思路：归并(类似数组的归并排序.), 复杂度O(nklgn), n:数组的个数, k:数组的平均长度.
 * 复杂度分析:
 * 第一轮: merge次数 n/2, 每次merge复杂度 2k, cost: nk;
 * 第二轮: merge次数 n/4, 每次merge复杂度 4k, cost: nk;
 * ...
 * 最后一轮复杂度也是nk;
 * 共有lgn轮，所以复杂度为O(knlgn).
 *
 */
public class MergeK {
    public static void main(String[] args) {
        int[][] arrays = {
                {1,4,7,10},
                {2,5,8},
                {3,6,9}
        };
        int[] rs = mergeKarray(arrays);
        for(int e: rs) System.out.print(e + " ");
    }

    public static int[] mergeKarray(int[][] arrays) {
        if(arrays == null) return null;
        return recursion(arrays, 0, arrays.length-1);
    }

    public static int[] recursion(int[][] arrays, int l, int r) {
        if(l > r) return null;
        if(l == r) return arrays[l];
        int mid = (r-l)/2 + l;
        int[] left = recursion(arrays, l, mid);
        int[] right = recursion(arrays, mid+1, r);
        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null) return arr2 == null ? arr1 : arr2;
        int[] rs = new int[arr1.length + arr2.length];
        int l1 = 0, l2 = 0, idx=0;
        for(; l1<arr1.length && l2<arr2.length; ) {
            if(arr1[l1] <= arr2[l2]) rs[idx++] = arr1[l1++];
            else rs[idx++] = arr2[l2++];
        }
        for(; idx<arr1.length+arr2.length && l1 < arr1.length;) rs[idx++] = arr1[l1++];
        for(; idx<arr1.length+arr2.length && l2 < arr2.length;) rs[idx++] = arr2[l2++];
        return rs;
    }
}
