package exam;

import java.util.Scanner;

public class MT02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int num = in.nextInt();
            int bit = 0;
            for(int i=0; i<num; i++) bit = in.nextInt();
            if(bit == 1) System.out.println("Alice");
            else System.out.println("Bob");
        }
        in.close();
    }
}
