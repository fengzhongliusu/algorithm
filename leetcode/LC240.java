package leetcode;

/**
 * author: cshuo
 * date: 2017/8/5
 * version: 1.0
 * description:
 *
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,
 Consider the following matrix:
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.
 Given target = 20, return false.
 */
public class LC240 {
    /**
     * 思路: 从右上角(左下角)开始搜索,target大的话,向下走; 小的话,向左走, 直到超出边界.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[0].length < 1) return false;
        int i = 0, j = matrix[0].length-1;
        while(i < matrix.length && j > -1) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
