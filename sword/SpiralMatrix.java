package sword;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/5/2
 * version: 1.0
 * description: 螺旋矩阵.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[1][1];
        makeMatrix(matrix);
        List<Integer> rs = printMatrix(matrix);
        System.out.println(rs);
    }

    /**
     * @param matrix: 矩阵
     * @return 两个坐标分别记录左上角坐标和右下角坐标, 每轮分四个边进行遍历;
     */
    public static List<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int num = 1, endR = matrix.length, endC = matrix[0].length,
                beR = 0, beC = 0;
        ArrayList<Integer> rs = new ArrayList<>();
        int i, j;

        while (num <= matrix.length * matrix[0].length) {
            for (i = beR, j = beC; j < endC; j++, num++)
                rs.add(matrix[i][j]);
            for (i = beR + 1, j = endC - 1; i < endR; i++, num++)
                rs.add(matrix[i][j]);
            for (i = endR - 1, j = endC - 2; i > beR && j >= beC; j--, num++)
                rs.add(matrix[i][j]);
            for (i = endR - 2, j = beC; i > beR && j < endC - 1; i--, num++)
                rs.add(matrix[i][j]);
            beR++; beC++; endR--; endC--;
        }
        return rs;
    }

    /**
     * @param matrix: 目标矩阵
     *                将 1, 2, ... , N 按照环形走法填到矩阵中.
     */
    public static void makeMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;

        int num = 1, endR = matrix.length, endC = matrix[0].length,
                beR = 0, beC = 0;
        int i, j;

        while (num <= matrix.length * matrix[0].length) {
            for (i = beR, j = beC; j < endC; j++)
                matrix[i][j] = num++;
            for (i = beR + 1, j = endC - 1; i < endR; i++)
                matrix[i][j] = num++;
            for (i = endR - 1, j = endC - 2; j >= beC && i > beR; j--)
                matrix[i][j] = num++;
            for (i = endR - 2, j = beC; i > beR && j < endC - 1; i--)
                matrix[i][j] = num++;
            beC++; beR++; endC--; endR--;
        }
    }
}
