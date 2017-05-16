package collections.sort;

/**
 * Created by cshuo on 2017/2/13.
 *
 * Time: O(N^2)
 */
public class Selection extends Sort {
    public static void sort(int[] a){
        int N = a.length;
        int min;
        for(int i=0; i<N; i++){
            min = i;
            for(int j=i+1; j<N; j++){
                if(a[j] < a[min])
                    min = j;
            }
            swap(a, i, min);
        }
    }

    public static void main(String[] args){
        int []a = {1,3,4,2,7,5,2,2,0};
        Selection.sort(a);
        Selection.printList(a);
    }
}
