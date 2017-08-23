package collections.dp;

import java.util.Scanner;

/**
 * Created by cshuo on 2017/8/14
 *
 * Min Cost Path.
 *
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path
 * to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell
 */
public class MCP {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int cases = in.nextInt();
        for(int c=0; c<cases; c++) {
            int N = in.nextInt();
            int[][] mat = new int[N][N];
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    mat[i][j] = in.nextInt();
            System.out.println(findMin(mat, 1, 3));
        }
        in.close();
    }

    public static int findMin(int[][] matrix, int r, int c) {
        if(matrix == null || matrix.length < 1) return 0;
        int[][] dp = new int[r+1][c+1];
        for(int i=0; i<=r; i++)
            for(int j=0; j<=c; j++){
                if(i == 0 && j == 0) dp[i][j] = matrix[i][j];
                else if(i == 0) dp[i][j] = dp[i][j-1] + matrix[i][j];
                else if(j == 0) dp[i][j] = dp[i-1][j] + matrix[i][j];
                else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        return dp[r][c];
    }
}
