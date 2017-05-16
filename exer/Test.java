package exer;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1000000000000000000000");
        BigInteger b = new BigInteger("2000000000000000000001");
        System.out.println(a.multiply(b));
        Scanner in = new Scanner(System.in);
        double d = in.nextDouble();
        System.out.println(d);
        System.out.println(Double.valueOf(String.format("%.2f", 4*1.0/9)));
    }
}

