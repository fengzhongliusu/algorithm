package leetcode;

/**
 * Created by cshuo on 2021/7/8
 */
public class LC605 {
    public static void main(String[] args) {
        LC605 test = new LC605();
        System.out.println(test.canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
    }
    // 对于 idx 0，认为其左边为 0.
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (prev == 1 || flowerbed[i] == 1) {
                prev = flowerbed[i];
                continue;
            }
            if (flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
            if (n == 0) {
                return true;
            }
            prev = flowerbed[i];
        }
        if (prev == 0 && flowerbed[flowerbed.length-1] == 0) {
            n--;
        }
        return n < 1;
    }
}
