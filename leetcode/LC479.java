package leetcode;

public class LC479 {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(3));
    }

    public static int largestPalindrome(int n) {
        int max = -1;
        long r = (long)Math.pow(10, n) - 1, l = (long)Math.pow(10, n-1);
        String tmp, reverse;
        StringBuilder sb = new StringBuilder();
        for(long i=r; i>=l; i--)
            for(long j=r; j>=l; j--) {
                sb.setLength(0);
                tmp = Long.toString(i*j);
                reverse = sb.append(tmp).reverse().toString();
                System.out.println(tmp + ", " + reverse);
                if(tmp.equals(reverse)) return (int)(i*j%1337);
            }
        return 0;
    }
}
