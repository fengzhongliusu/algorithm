package hiho;

import leetcode.Main;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/3/25
 * version: 1.0
 * description:
 */
public class Sim2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int pair = 0;
        while(sc.hasNext()){
            num = sc.nextInt();
            pair = 0;
            double sqrt = Math.sqrt(num);
            int intSqrt = (int)sqrt;
            int tmp;
            for(int i=0; i<=intSqrt; i++){
                tmp = (int) (num - Math.pow(i, 2));
                if(isPerf(tmp)){
                    if(i == 0 && tmp == 0) pair += 1;
                    else if(i==0 || tmp == 0) pair += 2;
                    else pair += 4;
                }
            }
            System.out.println(pair);
        }
        sc.close();
    }

    public static boolean isPerf(int number){
        double sq = Math.sqrt(number);
        int intSQ = (int)sq;
        return  Math.pow(sq, 2) == Math.pow(intSQ, 2);
    }
}
