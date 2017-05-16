package collections.sort;

/**
 * Created by cshuo on 2017/2/13.
 * Time NlgN
 */
public class Quick extends Sort {
    public static void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int low, int hi){
        if(low >= hi) return;
        int p = partition2(a, low, hi);
        sort(a, low, p-1);
        sort(a, p+1, hi);
    }

    /**
     * @param a
     * @param k
     * @param low
     * @param hi
     * @return use quick sort find the Kth number in array.
     */
    private static int findK(int[] a, int k, int low, int hi){
        if(k > hi - low + 1) return -1;
        int p = partition2(a, low, hi);
        if(p - low  == k-1) return a[p];
        else if(p-low < k -1) return findK(a, k-p+low-1, p+1, hi);
        else return findK(a, k, low, p-1);
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

    public static int partition3(int[] arr, int low, int high){
        int pivot = arr[low];
        int i= low, j = high;
        while(i<=j){
            while(i<=j && arr[i]<=pivot)i++;
            while(i<=j && arr[j]>=pivot)j--;
            swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }


    /**
     * @param a
     * @param low
     * @param hi
     * @return
     * 更简洁, 更易理解
     */
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

    private static int exer(int[] a, int low, int hi){
        return 0;
    }

    public static void main(String[] args){
        int []a = {1,1,0,-1,2,3,1,10,9,4,8,6};
        Quick.sort(a);
        Quick.printList(a);
        // -1, 0, 1, 1, 1, 2, 3, 4, 6, 8, 9, 10
        System.out.println(findK(a, 12, 0, a.length-1));
    }
}
