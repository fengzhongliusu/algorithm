package exam;

/**
 * author: cshuo
 * date: 2017/4/18
 * version: 1.0
 * description:
 */
import java.util.HashSet;
import java.util.Scanner;

public class Toutiao02 {
    public static void main(String[] args) {
        // TODO code application logic here
        HashSet<Long> hset = new HashSet<Long>();


        Scanner in = new Scanner(System.in);
        while(in.hasNextLong()) {
            Long val = in.nextLong();

            if(val == 0) break;
            hset.add(val);
        }
        System.out.println(hset.size());
    }

}
