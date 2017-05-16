package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/3/25
 * version: 1.0
 * description:
 */
public class Net03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
            int[] arr =new int[n];
            int[] tmp =new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            System.arraycopy(arr, 0, tmp, 0, arr.length);

            for(int i=0; i<k; i++){
                for(int j=0; j<arr.length-1; j++){
                    arr[j] = (tmp[j] + tmp[j+1]) % 100;
                }
                arr[arr.length - 1] = (tmp[arr.length-1] + tmp[0]) % 100;
                System.arraycopy(arr, 0, tmp, 0, arr.length);
                if(arr[0] == 53 && arr[1] == 51 && arr[2] == 52)
                    System.out.println(i + ": get pattern");
            }
            for(int i=0; i<arr.length-1; i++)
                System.out.print(arr[i] + " ");
            System.out.print(arr[arr.length - 1]);
        }
    }
}
