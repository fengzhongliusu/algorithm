package collections.sort;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by cshuo on 2017/2/13.
 *
 * Time: NlgN
 */
public class Merge extends Sort {
    private static int[] temp;
    public static void sort(int[] a){
        int N = a.length;
        temp = new int[N];
        mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(int[] a, int low, int hi){
        if (low >= hi) return;
        int mid = (hi - low) / 2 + low;
        mergeSort(a, low, mid);
        mergeSort(a, mid+1, hi);
        merge(a, low, mid, hi);
    }

    private static void merge(int[] a, int low, int mid, int hi){
        int k = mid + 1;
        int l = low;

        for(int i = low; i<=hi; i++){
            temp[i] = a[i];
        }
        for(int j = low; j<=hi; j++){
            if(l> mid) a[j] = temp[k++];
            else if (k > hi) a[j] = temp[l++];
            else if (temp[l] > temp[k]) a[j] = temp[k++];
            else a[j] = temp[l++];
        }
    }

    public static void main(String[] args){
        int []a = {1,3,4,2,7,5,2,2,0};
        Merge.sort(a);
        Merge.printList(a);


    }
}

