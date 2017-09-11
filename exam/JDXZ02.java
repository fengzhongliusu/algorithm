package exam;

import java.util.Scanner;

public class JDXZ02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            System.out.println(brute(n));
            System.out.println(getNum(n));
        }
        in.close();
    }

    public static int brute(int n) {
        long sum = 0;
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                for(int p=1; p<=n; p++)
                    for(int q=1; q<=n; q++)
                        if((int)Math.pow(i, j) == (int)Math.pow(p, q)) sum = (sum + 1) % 1000000007;

        return (int)sum;
    }

    public static int getNum(int n) {
        int mod = 1000000007;
        long sum = (n * n) % mod;
        for(int i=2; i<=n; i++) {
            sum = (sum + n) % mod;
            for(int j=2; j<=n; j++) {
                int pair = getMulti(i, j, n);
                sum = (sum + pair) % mod;
            }
        }
        return (int)sum;
    }

    public static int getMulti(int mid, int n, int max) {
        long count = 0;
        for(int i=1; i <= n; i++) {
            if(n % i == 0) {
                if((int)Math.pow(mid, i) <= max
                        && (int)Math.pow(mid, n/i) <= max
                        && i <= max
                        && n/i <= max) count = (count + 1 ) % 1000000007;
            }
        }
        return (int)count;
    }
}
