package exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

/**
 * sort a large array using multi-threads.
 */
public class MultiThreadSort {
    ArrayList<Thread> thds = new ArrayList<Thread>();
    ExecutorService ex = Executors.newCachedThreadPool();

    public void swap(int[] arr, int m ,int n){
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public int partion(int[] arr, int l, int h){
        int k = l, m = h + 1;
        while (true){
            while(++k < h && arr[k] <= arr[l]);
            while(--m > l && arr[m] >= arr[l]);
            if(k >= m) break;
            swap(arr, k, m);
        }
        swap(arr, l, m);
        return m;
    }

    public void multiSortV2(final int threads, final int[] arr, final int bg, final int end){
        if(threads > 1){
            final int mid = partion(arr, bg, end);
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    multiSortV2(threads-1, arr, bg, mid-1);
                }
            });
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    multiSortV2(threads-1, arr, mid+1, end);
                }
            });
        } else {
            Arrays.sort(arr, bg, end+1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[]{8,3,4,20,-1,2,323,23,23,23,2,1,21,2,434,35,-1,1
                ,23,24,34,34,5454,545,-10,45,4,2,-30,2342,34,234,234,-2,3,34};
        MultiThreadSort ms = new MultiThreadSort();
        ms.multiSortV2(1, a, 0, a.length - 1);
        ms.ex.shutdown();
        while(!ms.ex.awaitTermination(10, TimeUnit.MINUTES));

        for(int e: a)
            System.out.print(e + " ");
        System.out.println();
    }
}
