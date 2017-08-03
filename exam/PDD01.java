package exam;

import java.util.Scanner;

/**
 * Created by cshuo on 2017/8/1
 * 无序整数数组找出乘积最大的三个数
 * 思路：找出最大的三个数和最小的两个数，res = Max(最大三个数的乘积，最小两个数和最大数的乘积)；
 * Note!!!! 遇到整数相乘用Long!!!
 */
public class PDD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int[] maxNum = new int[3];
            int[] minNum = new int[3];
            int[] maxNegNum = new int[3];
            int zero = -1, hasPos = -1, posNum=0, negNum=0;
            int len = in.nextInt();
            int []nums = new int[len];

            for(int i=0; i<len; i++){
                nums[i] = in.nextInt();
                if(nums[i] == 0) zero = 1;
                else if(nums[i] > 0)
                {
                    hasPos = 1; posNum++;
                    putMaxNum(nums[i], maxNum);
                }
                else{
                    negNum++;
                    putMaxNum(nums[i], maxNegNum);
                    putMaxNum(-nums[i], minNum);
                }
            }
            if(posNum == 2)  {
                if(zero == 1) System.out.println(0);
                else {
                    int i =0;
                    for(i=3; i>=0; i--) if(maxNegNum[i] != 0) break;
                    System.out.println(maxNum[0]*maxNum[1]*maxNegNum[i]);
                }
            } if (posNum == 1) {
                if(negNum >= 2) {
                    int i;
                    for(i=3; i>=0; i--) if(minNum[i] != 0) break;
                    System.out.println(maxNum[0]*minNum[i]*minNum[i-1]);
                } else System.out.println(0);
            }
            else {
                if(negNum == 3) {
                    if(maxNum[0]*maxNum[1] > minNum[0]*minNum[1]) System.out.println(maxNum[0]*maxNum[1]*maxNum[2]);
                    else System.out.println(minNum[0]*minNum[1]*maxNum[2]);
                } else System.out.println(maxNum[0]*maxNum[1]*maxNum[2]);
            }

        }
        in.close();
    }

    public static void putMaxNum(int num, int[] arrs) {
        if(arrs[0] == 0) arrs[0] = num;
        else if(arrs[1] == 0) {
            if(num >= arrs[0])
                arrs[1] = num;
            else {
                arrs[1] = arrs[0];
                arrs[0] = num;
            }
        } else if(arrs[2] == 0) {
            if(num > arrs[1]) arrs[2] = num;
            else if(num >= arrs[0]) {
                arrs[2] = arrs[1];
                arrs[1] = num;
            } else {
                arrs[2] = arrs[1];
                arrs[1] = arrs[0];
                arrs[0] = num;
            }
        } else {
            if(num <= arrs[0]);
            else if(num <= arrs[1]) {
                arrs[0] = num;
            } else if(num <= arrs[2]) {
                arrs[0] =arrs[1];
                arrs[1] = num;
            } else {
                arrs[0] = arrs[1];
                arrs[1] = arrs[2];
                arrs[2] = num;
            }
        }
    }
}
