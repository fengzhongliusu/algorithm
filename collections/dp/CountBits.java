package collections.dp;

/**
 * 求0-n之间的数字二进制中1的个数.
 */
public class CountBits {
    public static int countBits(int num) {
        int sum = 0, pow2 = 1, before = 1;
        int rs[] = new int[num+1];
        for(int i=1; i<=num; i++) {
            if(i == pow2) {
                sum += 1;
                before = 1;
                rs[i] = 1;
                pow2 <<= 1;
            } else {
                rs[i] = rs[before] + 1;
                before += 1;
                sum+=rs[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }
}
