package leetcode;

/**
 * author: cshuo
 * date: 2017/8/5
 * version: 1.0
 * description:
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,
 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 */
public class LC74 {
    /**
     * 把该矩阵当成一个有序一维数组, 应用二分法搜索即可.
     * 注意二维矩阵坐标到一维数组坐标之间的转换.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[0].length < 1) return false;
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m*n - 1, mid;
        while(l <= r) {
            mid = (r-l)/2 + l;
            if(matrix[mid/n][mid%n] == target) return true;
            else if(matrix[mid/n][mid%n] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
