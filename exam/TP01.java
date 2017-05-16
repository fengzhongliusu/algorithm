package exam;

/**
 * author: cshuo
 * date: 2017/5/6
 * version: 1.0
 * description:
 */

public class TP01{
    public static void main(String[] args){
        int[] nums = {1,3,1,-3,5,3};
        printMax(nums, nums.length, 3);
    }

    public static void printMax(int[] arr, int m, int n){
        for(int begin=0; begin <=m-n; begin++){
            System.out.print(findMax(arr, begin, begin+n-1));
            if(begin < m-n) System.out.print(" ");
        }
        System.out.println();
    }

    public static int findMax(int[] arr, int l, int r){
        int max = arr[l];
        for(int i=l+1; i<=r; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
