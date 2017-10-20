package exam;

import java.util.Scanner;

public class TTT01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt(), m = in.nextInt();
            char[][] matrix = new char[n][m];
            for(int i=0; i<n; i++)
                matrix[i] = in.next().toCharArray();

        }
        in.close();
    }

}
