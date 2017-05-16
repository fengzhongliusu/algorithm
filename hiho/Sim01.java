package hiho;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/3/25
 * version: 1.0
 * description:
 */
public class Sim01 {
    public static void main(String[] args) {
        int len;
        int min;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            min = 0;
            len = sc.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++)
                arr[i] = sc.nextInt();

            int l = 0, r = len - 1;
            while(l < r){
                if(arr[l] < arr[r]){
                    arr[++l] += arr[l-1];
                    min += 1;
                } else if(arr[l] > arr[r]){
                    arr[--r] += arr[r+1];
                    min += 1;
                } else {
                    l++;
                    r--;
                }
            }
            System.out.println(min);
        }
        sc.close();
    }
}
