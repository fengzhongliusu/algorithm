package sword;

import collections.linkedList.Reverse;

/**
 * Created by cshuo on 2017/8/3
 */
public class ReversePair{
    private int[] helper;
    private int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[] {7,5,6,4};
        ReversePair t = new ReversePair();
        System.out.println(t.InversePairs(arr));
    }

    public int InversePairs(int [] array) {
        helper = new int[array.length];
        mergeSort(array, 0, array.length-1);
        return count;
    }

    public void mergeSort(int[] array, int l, int h) {
        if(l >= h) return;
        int mid = (h-l)/2 + l;
        mergeSort(array, l, mid);
        mergeSort(array, mid+1, h);
        merge(array, l, mid, h);
    }

    /**
     * m左子数组的游标，n右子数组游标; 比较时需要统计逆序对的情况是a[m] > a[n], 此时增加的逆序对数目是mid - m + 1个。
     */
    public void merge(int[] array, int l, int mid, int h) {
        int m = l, n = mid+1;
        for(int i=l; i<=h; i++)
            helper[i] = array[i];
        for(int i=l; i<=h; i++) {
            if(m>mid) array[i] = helper[n++];
            else if(n > h) array[i] = helper[m++];
            else if(helper[m] > helper[n]) {
                array[i] = helper[n++];
                count = (count + mid - m + 1) % 1000000007;
            } else array[i] = helper[m++];
        }
    }

}
