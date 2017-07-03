package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/5/27
 * version: 1.0
 * description:
 */
public class IND01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N, M;
            N = in.nextInt();
            M = in.nextInt();

            int []floors = new int[N];
            int []forbiden = new int[M];

            for(int i=0; i<N; i++)
                floors[i] = in.nextInt();
            for(int i=0; i<M; i++)
                floors[i] = in.nextInt();
        }
        in.close();
    }
}
