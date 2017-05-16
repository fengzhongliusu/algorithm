package hiho;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by cshuo on 2017/3/19
 */
public class Hiho3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCase;
        numCase = sc.nextInt();
        int len, k;
        int []arr;
        for(int i = 0; i<numCase; i++){
            len = sc.nextInt();
            k = sc.nextInt();
            arr = new int[len];
            for(int j = 0; j<len; j++)
                arr[j] = sc.nextInt();
            System.out.println(findKth(arr, k));
        }
    }

    public static int findKth(int[] nums, int k){
        int[] numP = new int[(nums.length*(nums.length+1)/2)];
        int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                numP[count++] = numPairs(nums, i, j);
            }
        }
        Arrays.sort(numP);
        return numP[k-1];
    }

    public static int numPairs(int[] nums, int bg, int end){
        if(bg == end) return 0;
        int sum = 0;
        for(int i=bg; i<end; i++){
            for(int j=i+1; j<end+1; j++){
                if(nums[i] == nums[j]) sum += 1;
            }
        }
        return sum;
    }
}
