package exam;

import java.util.Scanner;

public class WAP01 {
    static int min = Integer.MAX_VALUE;
    static int target;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            min = Integer.MAX_VALUE;
            int n = in.nextInt(), m = in.nextInt();
            char[][] mtx = new char[n][m];
            for(int i=0; i<n; i++) {
                mtx[i] = in.next().toCharArray();
            }
            target = in.nextInt();
            int[] dir = new int[] {0,0,0,0};
            dfs(mtx, dir, 0, n-1, 0, m-1, 0);
            System.out.println(min == Integer.MAX_VALUE ? -1:min);
        }
        in.close();
    }

    public static void dfs(char[][] mtx, int[] dir, int rowB, int rowE, int colB, int colE, int moves) {
        if(rowB >= mtx.length || rowE < 0 || colB >= mtx[0].length || colE < 0) return;
        if(count(mtx, rowB, rowE, colB, colE) == target) min = Math.min(moves, min);
        if(dir[1] != 1) {
            dir[0] = 1;
            dfs(mtx, dir, rowB, rowE-1, colB, colE, moves+1);
            dir[0] = 0;
        }
        if(dir[0] != 1) {
            dir[1] = 1;
            dfs(mtx, dir,rowB+1, rowE, colB, colE, moves+1);
            dir[1] = 0;
        }
        if(dir[3] != 1) {
            dir[2] = 1;
            dfs(mtx, dir, rowB, rowE, colB, colE-1, moves+1);
            dir[2] = 0;
        }
        if(dir[2] != 1) {
            dir[3] = 1;
            dfs(mtx, dir, rowB, rowE, colB+1, colE, moves+1);
            dir[3] = 0;
        }
    }

    public static int count(char[][] mtx, int rowB, int rowE, int colB, int colE) {
        int nums = 0;
        for(int i=rowB; i<=rowE; i++) {
            for(int j=colB; j<=colE; j++) {
                if(mtx[i][j] == 'o') nums++;
            }
        }
        return nums;
    }
}
