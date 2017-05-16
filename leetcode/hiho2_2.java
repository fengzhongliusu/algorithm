package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * hihocoder 水陆距离
 */
public class hiho2_2 {
    private static final int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] bitMt = new String[n];
        Queue<int[]> bitQ = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            bitMt[i] = in.next();
        }

        int[][] disM = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bitMt[i].charAt(j) == '0') {
                    disM[i][j] = 0;
                    bitQ.add(new int[]{i, j});
                } else {
                    disM[i][j] = -1;
                }
            }
        }

        int[] tmp;
        int x, y;
        while (!bitQ.isEmpty()) {
            tmp = bitQ.poll();
            for (int i = 0; i < 4; i++) {
                x = tmp[0] + dir[i][0];
                y = tmp[1] + dir[i][1];
                if (x < n && x > -1 && y < m && y > -1 && disM[x][y] == -1) {
                    disM[x][y] = disM[tmp[0]][tmp[1]] + 1;
                    bitQ.add(new int[]{x, y});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(disM[i][j] + " ");
            }
            System.out.println();
        }
    }
}
