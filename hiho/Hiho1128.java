package hiho;

import java.util.Arrays;
import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description:
 */
public class Hiho1128 {
    public static void findKth(int[] arr, int ele, int l, int r){
        if(r == l && arr[l] == ele){
            System.out.println(l+1);
            return;
        }
        if(r <= l){
            System.out.println(-1);
            return;
        }
        int mid = (l + r) / 2;
        if(arr[mid] == ele){
            System.out.println(mid+1);
            return;
        } else if(ele < arr[mid])
            findKth(arr, ele, l, mid - 1);
        else
            findKth(arr, ele, mid+1, r);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len, ele;
        len = sc.nextInt();
        ele = sc.nextInt();
        int[] arr = new int[len];
        for(int i=0; i<len; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        findKth(arr, ele, 0, len-1);
    }
}
