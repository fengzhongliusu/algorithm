package exam;

import java.util.Scanner;


public class TT003{

    /**
     * 给定一个数组，找出其中一个连续子数组，满足，子数组最小值和子数组和的乘积最大，返回乘积即可，
     * 数组中的每个元素e大小为[1,100].
     */
    public static int maxValue(int n, int[] arr){
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]>=i) {
                    sum+= arr[j];
                    int tmp = i*sum;
                    result = result>tmp? result:tmp;
                }else{
                    sum = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int result = maxValue(n,arr);
            System.out.println(result);

        }

    }

}
