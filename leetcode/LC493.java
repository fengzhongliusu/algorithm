package leetcode;

/**
 * Created by cshuo on 2017/8/3
 Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 You need to return the number of important reverse pairs in the given array.
 Example1:
 Input: [1,3,2,3,1]
 Output: 2
 */

public class LC493{
    private int count = 0;
    private int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        return count;
    }

    private void mergeSort(int[] a, int low, int hi){
        if (low >= hi) return;
        int mid = (hi - low) / 2 + low;
        mergeSort(a, low, mid);
        mergeSort(a, mid+1, hi);
        merge(a, low, mid, hi);
    }

    private void merge(int[] a, int low, int mid, int hi){
        // 统计逆序对个数, 可以扩展逆序对的定义，如 a[low] > K * a[high]等；
        for(int m=low, n=mid+1; m<= mid; ) {
            if(n > hi || (long)a[m] <= (long)2*a[n]) m++;
            else {
                if((long)a[m] > (long)2*a[n]) count += mid - m + 1;
                n++;
            }
        }
        // 归并排序的merge操作.
        int k = mid + 1, l = low;
        for(int i = low; i<=hi; i++)
            temp[i] = a[i];
        for(int j = low; j<=hi; j++) {
            if(l> mid) a[j] = temp[k++];
            else if (k > hi) a[j] = temp[l++];
            else if (temp[l] > temp[k]) a[j] = temp[k++];
            else a[j] = temp[l++];
        }
    }
}
