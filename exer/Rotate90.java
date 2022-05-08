package exer;

/**
 * Created by cshuo on 2021/8/29
 */
public class Rotate90 {
    public static void main(String[] args) {
        int[][] nums = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] rs = rotate(nums);
        for (int[] es: rs) {
            for (int e: es) {
                System.out.print(e + ",");
            }
            System.out.println();
        }
    }
    private static int[][] rotate(int[][] nums) {
        int[][] rs = new int[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                rs[j][nums.length - 1 - i] = nums[i][j];
            }
        }
        return rs;
    }
}
