package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/4/27
 * version: 1.0
 * description: 1.2...N 排列中, 每个数字之间是 ">" 或 "<" 关系, 求满足有K个 "<" 关系的排列个数
 */
public class BD031 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int [][] rs;
        while(in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            rs = new int[n+1][k+1];
            for(int i=0; i<=n; i++){
                rs[i][0] = 1;
                if(i<=k) rs[0][i] = 0;
            }

            for(int i=1; i<=n; i++)
                for(int j=1; j<=k; j++){
                    rs[i][j] = rs[i-1][j] * (j+1) + rs[i-1][j-1]*(i-j);
                    rs[i][j] %= 2017;
                }

            System.out.println(rs[n][k]);
        }
    }
}
