package collections.sort;

/**
 * Created by cshuo on 2017/2/13.
 *
 * Time: O(N^2)
 */
public class Insertion extends Sort {
    public static void sort(int[] a){
        int N = a.length;
        for(int i = 1; i<N; i++){
            for(int j = i; j>0 && a[j]<a[j-1]; j--){
                swap(a, j, j-1);
            }
        }
    }

    public static void main(String[] args){
        int []a = {1,3,4,2,7,5,2,2,0};
        Insertion.sort(a);
        Insertion.printList(a);
    }
}
