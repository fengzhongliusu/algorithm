package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cshuo on 2022/1/16
 */
public class LC2133 {
    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,2,3}, {3,1,2}, {2,3,1}};
        System.out.println(checkValid(mat));
    }
    public static boolean checkValid(int[][] matrix) {
        Set<Integer> expected = new HashSet<>();
        for (int i = 1; i <= matrix.length; i++) {
            expected.add(i);
        }
        Set<Integer> tmp = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            tmp.clear();
            for (int j = 0; j < matrix.length; j++) {
                if (tmp.contains(matrix[i][j])) {
                    return false;
                }
                if (!expected.contains(matrix[i][j])) {
                    return false;
                }
                tmp.add(matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            tmp.clear();
            for (int j = 0; j < matrix.length; j++) {
                int num = matrix[j][i];
                if (tmp.contains(num)) {
                    return false;
                }
                if (!expected.contains(num)) {
                    return false;
                }
                tmp.add(num);
            }
        }
        return true;
    }
}
