package leetcode;

/**
 * Created by cshuo on 2021/8/6
 */
public class LC135 {
    public static void main(String[] args) {
        System.out.println(candy(new int[] {1,0,2}));
    }
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < candies.length; i++) {
            candies[i] = 1;
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        int total = 0;
        for (int i = candies.length - 1; i >= 1; i--) {
            if (ratings[i-1] > ratings[i]) {
                candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
            }
            total += candies[i-1];
        }
        return total + candies[candies.length - 1];
    }
}
