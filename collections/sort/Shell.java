package collections.sort;

/**
 * Created by cshuo on 2017/2/13.
 * Sort based on Insertion Sort. (h to 1 step Insertion Sort)
 *
 * Time: < O(N^2), worst: O(N^1.5)
 */
public class Shell extends Sort {
    public static void sort(int[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = h*3 +1;
        while(h>=1){
            for(int i = h; i < N; i++){
                for(int j = i; j>=h && a[j] < a[j-h]; j -= h){
                    swap(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String []args){
        int []a = {1,3,4,2,7,5,2,2,0};
        Shell.sort(a);
        Shell.printList(a);
    }
}
