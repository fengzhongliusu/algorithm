package exam;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by cshuo on 2017/8/12
 */
public class NNNet01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            long x = in.nextLong(), f = in.nextLong(), d = in.nextLong(), p = in.nextLong();
            BigInteger m = new BigInteger(Long.toString(d+f*p)).divide(new BigInteger(Long.toString(x+p)));
            System.out.println(m.toString());
        }
    }
}

