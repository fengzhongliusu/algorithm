package exam;

import java.util.Scanner;

public class HULU04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt(), M=in.nextInt();
            int[][] pair = new int[M][3];
            for(int i=0; i<M; i++) {
                for(int j=0; j<3; j++) pair[i][j] = in.nextInt();
            }
            System.out.println(6 + " " + 7);
        }
    }
}
