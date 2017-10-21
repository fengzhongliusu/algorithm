package collections.sort;

import java.util.Stack;

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
     * 非递归写法. 典型的尾递归转迭代写法，每次跌打一个分支的话，可以直接用一个局部变量进行更新；多个分支的话用栈或队列皆可.
     */
    public static void sort2(int[] a, int low, int hi) {
        int p, init = 0;
        Stack<Integer> st = new Stack<>();
        while(init == 0 || !st.isEmpty()) {
            if(init != 0) { hi=st.pop(); low=st.pop(); }
            init = 1;
            p = partition2(a, low, hi);
            if(low < p-1) { st.push(low); st.push(p-1); }
            if(hi > p+1) { st.push(p+1); st.push(hi); }
        }
    }

    /**
     * @return use quick sort find the Kth number in array.
     */
    public static int findKth(int[] nums, int l, int r, int k) {
        if(l > r) return -1;
        int p = partition2(nums, l, r);
        if(p == k) return nums[p];
        else if(p > k) return findKth(nums, l, p-1, k);
        else return findKth(nums, p+1, r, k);
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
        int tmp = a[low];
        while(low < hi) {
            while(low < hi && a[hi] >= tmp) hi--;
            a[low] = a[hi];
            while(low < hi && a[low] <= tmp) low++;
            a[hi] = a[low];
        }
        a[low] = tmp;
        return low;
    }

    public static void main(String[] args){
        int []a = {1,1,0,-1,2,3,1,10,9,4,8,6};
        Quick.sort2(a, 0, a.length-1);
        Quick.printList(a);
        // -1, 0, 1, 1, 1, 2, 3, 4, 6, 8, 9, 10
        System.out.println(findKth(a, 0, a.length-1, 12));
    }
}
