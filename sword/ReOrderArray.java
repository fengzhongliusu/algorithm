package sword;

import java.util.Arrays;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,10,0};
        reOrder(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reOrder(int[] array){
        int tmp, j;
        for(int i=0; i<array.length;i++){
            if((array[i]&1) == 0){
                for(j=i+1; j < array.length; j++){
                    if((array[j]&1) == 1) break;
                }
                if(j >= array.length) return;
                tmp = array[j];
                for(int k = j; k> i; k--)
                    array[k] = array[k-1];
                array[i] = tmp;
            }
        }
    }
}
