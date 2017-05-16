package exam;

import java.util.Scanner;

/**
 * author: cshuo
 * date: 2017/5/7
 * version: 1.0
 * description:
 */
public class DD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n, m;
            n = in.nextInt();
            m = in.nextInt();
            char[][] grid = new char[n][m];
            String tmp;
            for(int i=0; i<n; i++){
                tmp = in.next();
                grid[i] = tmp.toCharArray();
            }

            System.out.println(numIslands(grid));
        }
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void clearIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        clearIsland(grid, i+1, j);
        clearIsland(grid, i-1, j);
        clearIsland(grid, i, j+1);
        clearIsland(grid, i, j-1);
    }
}
