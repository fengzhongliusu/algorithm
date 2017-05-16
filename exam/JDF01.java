package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/4/7
 * version: 1.0
 * description:
 */
public class JDF01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String a, b;
            int len;
            int inta, intb;
            len = in.nextInt();
            a = in.next();
            b = in.next();
            inta = Integer.parseInt(a, 2);
            intb = Integer.parseInt(b, 2);
            System.out.println(inta ^ intb);
        }
    }
}
