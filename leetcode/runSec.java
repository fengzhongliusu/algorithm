package leetcode;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class runSec {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        String e = scan.nextLine().trim();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long start = df.parse(s).getTime();
        long end = df.parse(e).getTime();
        long ans = (end - start) / 1000;
        System.out.println(ans);
    }
}
