package leetcode;

import java.util.*;
import java.util.Map;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description:
 */
public class LC73 {

    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
     *
     * 设置一个行标记数组以及一个列标记数组.
     */
    public void setZeroes(int[][] matrix) {
        if(matrix.length < 1) return;

        int[] row_sign = new int[matrix.length];
        int[] col_sign = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length;j++)
                if(matrix[i][j] == 0){
                    row_sign[i] = 1;
                    col_sign[j] = 1;
                }

        for(int i=0; i<matrix.length; i++){
            if(row_sign[i] == 1)
                for(int j=0; j<matrix[0].length; j++)
                    matrix[i][j] = 0;
        }

        for(int j=0; j<matrix[0].length; j++){
            if(col_sign[j] == 1)
                for(int i = 0; i<matrix.length; i++)
                    matrix[i][j] = 0;
        }

    }

    public void setZr(int[][] matrix){
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
        int row = matrix.length, col = matrix[0].length;

        boolean r=false, c=false;
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if(i == 0) r = true;
                    if(j == 0) c = true;
                }

        for(int i=1; i<row; i++)
            if(matrix[i][0] == 0)
                for(int j=1; j<col; j++)
                    matrix[i][j] = 0;

        for(int j=1; j<col; j++)
            if(matrix[0][j] == 0)
                for(int i=1; i<row; i++)
                    matrix[i][j] = 0;

        if(r)
            for(int j=0; j<col; j++)
                matrix[0][j] = 0;
        if(c)
            for(int i=1; i<row; i++)
                matrix[i][0] = 0;
    }
}
