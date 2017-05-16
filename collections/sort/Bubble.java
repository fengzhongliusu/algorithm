package collections.sort;

/**
 * author: cshuo
 * date: 2017/4/5
 * version: 1.0
 * description:
 */
public class Bubble extends Sort {
    public static void sort(int[] arr){
        for(int i=arr.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    public static void main(String []args){
        int []a = {1,3,4,2,7,5,2,2,0};
        Bubble.sort(a);
        Bubble.printList(a);
        System.out.println("Asdf".toLowerCase());
    }
}
