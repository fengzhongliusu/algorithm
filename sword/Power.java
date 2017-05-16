package sword;

/**
 * author: cshuo
 * date: 2017/5/1
 * version: 1.0
 * description:
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(power(2, -3));
    }

    public static double power(double base, int exp){
        double rs = 1.0;
        int abs_exp = Math.abs(exp);
        while(abs_exp-->0){
            rs *= base;
        }
        return exp > 0? rs: 1/rs;
    }

    public static double power2(double base, int exp){
        return 0;
    }
}
