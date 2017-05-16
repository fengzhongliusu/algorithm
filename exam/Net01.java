package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/3/25
 * version: 1.0
 * description:
 */
public class Net01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numP, minT;
        int walkC, driveC;
        int ox, oy;
        while(sc.hasNext()){
            numP = sc.nextInt();
            minT = Integer.MAX_VALUE;
            int[][] points = new int[numP][2];
            for(int i=0; i<numP; i++)
                points[i][0] = sc.nextInt();
            for(int i=0; i<numP; i++)
                points[i][1] = sc.nextInt();

            ox = sc.nextInt();
            oy = sc.nextInt();
            walkC = sc.nextInt();
            driveC = sc.nextInt();

            int cost;
            for(int i=0; i<numP; i++){
                cost = (Math.abs(points[i][0]) + Math.abs(points[i][1])) * walkC;
                cost += (Math.abs(points[i][0] - ox) + Math.abs(points[i][1] - oy)) * driveC;
                if(cost < minT) minT = cost;
            }

            minT = Math.min(minT, (Math.abs(ox)+Math.abs(oy))*walkC);
            System.out.println(minT);
        }
    }
}
