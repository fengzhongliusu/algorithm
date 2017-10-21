package collections.dp;

/**
 * 求0-n之间的数字二进制中1的个数.
 * 思路: 两种情况: 1) num是2的幂, 结果为1; 2) num不是2的幂，则num可以表示成 2^x + left, 则包含1的个数是 1 + ans[left].
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
