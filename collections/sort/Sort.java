package collections.sort;

/**
 * Created by cshuo on 2017/2/13
 */
public class Sort {
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printList(int[] a){
        for(int i: a){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
