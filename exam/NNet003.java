package exam;
import java.util.*;

/**
 * Created by cshuo on 2017/8/12
 * 所求数组长度 n, 元素大小[1, k]; 对于相邻元素A,B, 满足A<=B 或 A%B != 0;
 * 求所有满足条件的数组个数.
 */
public class NNet003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt(), k = in.nextInt();
            System.out.println(numOfPerm(n, k));
        }
        in.close();
    }

    /**
     * dp[i][j]: 长度为i，以j结尾的数组个数.
     */
    public static long numOfPerm(int n, int k) {
        long [][] dp = new long[n+1][k+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=k; j++)
                if(i == 1) dp[i][j] = 1;

        // 递推关系：前一个数A与后一个数B的关系只需满足：B不是A的约数即可.
        // 所以 dp[i][j]等于Sum(dp[i-1][k])其中k % j != 0;
        for(int i=2; i<=n; i++) {
            long sum = 0;
            for(int j=1; j<=k; j++) sum = (sum + dp[i-1][j]) % 1000000007;
            for(int j=1; j<=k; j++) {
                long sum2 = 0;
                for(int q=2*j; q<=k; q+=j) sum2 = (sum2+dp[i-1][q]) % 1000000007;
                dp[i][j] = (sum - sum2 + 1000000007) % 1000000007;
            }
        }

        long sum = 0;
        for(int i=1; i<=k; i++) sum = (sum + dp[n][i]) % 1000000007;
        return sum;
    }
}
